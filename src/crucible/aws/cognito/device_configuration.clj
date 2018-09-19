(ns crucible.aws.cognito.device-configuration
  "Amazon Cognito DeviceConfiguration, a property of AWS::Cognito::UserPool"
  (:require [clojure.spec.alpha :as s]
            [crucible.resources :refer [spec-or-ref defresource] :as res]))

(s/def ::challenge-required-on-new-device (spec-or-ref boolean?))
(s/def ::device-only-remembered-on-user-prompt (spec-or-ref boolean?))
(s/def ::resource-property-spec (s/keys :opt [::challenge-required-on-new-device
                                              ::device-only-remembered-on-user-prompt]))
