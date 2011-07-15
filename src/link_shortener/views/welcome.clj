(ns link-shortener.views.welcome
  (:import (org.apache.commons.validator UrlValidator))
  (use noir.core
       hiccup.core
       hiccup.page-helpers
       hiccup.form-helpers)
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
           (resp/json {:link link})
           (resp/empty)))
