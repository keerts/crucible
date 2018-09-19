(ns crucible.aws.cognito.sms-configuration
  "Amazon Cognito SMSConfiguration, a property of AWS::Cognito::UserPool"
  (:require [clojure.spec.alpha :as s]
            [crucible.resources :refer [spec-or-ref defresource] :as res]))

(s/def ::sns-caller-arn (spec-or-ref string?))
(s/def ::external-id (spec-or-ref string?))

(s/def ::resource-property-spec (s/keys :req [::sns-caller-arn]
                                        :opt [::external-id]))
