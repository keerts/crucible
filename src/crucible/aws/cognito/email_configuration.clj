(ns crucible.aws.cognito.email-configuration
  "Amazon Cognito EmailConfiguration, a property of AWS::Cognito::UserPool"
  (:require [clojure.spec.alpha :as s]
            [crucible.resources :refer [spec-or-ref defresource] :as res]))

(s/def ::reply-to-email-address (spec-or-ref string?))
(s/def ::source-arn (spec-or-ref string?))

(s/def ::resource-property-spec (s/keys :opt [::reply-to-email-address
                                              ::source-arn]))
