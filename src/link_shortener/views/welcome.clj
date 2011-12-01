(ns link-shortener.views.welcome
  (:import (org.apache.commons.validator UrlValidator))
  (use noir.core
       hiccup.core
       hiccup.page-helpers
       hiccup.form-helpers)
  (:use [link-shortener.counter :only (get-shortened-link)])
  (:use [link-shortener.db :as db])
  (:use [link-shortener.config])
  (:require [link-shortener.views.common :as common]
            [noir.response :as resp]))

(def includes {})

(def validator (new UrlValidator))

(defpartial link_form []
          (form-to [:post "/shorten"]
                   (label "link" "Link to Shorten:")
                   (text-field "link")
                   (submit-button "Shorten")))

(defpage "/" []
         (common/layout
           (link_form)))

(defpage [:post "/shorten"] {:keys [link]}
  (if (.isValid validator link)
    (let [suffix (get-shortened-link)
          short (str shortened-prefix suffix)]
      (db/add-link suffix link)
      (resp/json {:longlink link 
                  :shortlink short}))
    (resp/json {:result "invalid link"})))

(defpage [:get "/:suffix"] {:keys [suffix]}
  (resp/redirect (db/get-link suffix)))
