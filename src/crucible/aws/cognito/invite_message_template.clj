(ns crucible.aws.cognito.invite-message-template
  "Amazon SQS InviteMessageTemplate, a subproperty of
  AWS::Cognito::UserPool AdminCreateUserConfig"
  (:require [clojure.spec.alpha :as s]
            [crucible.encoding.keys :refer [->key]]
            [crucible.resources :refer [spec-or-ref defresource] :as res]))

(s/def ::email-message (spec-or-ref string?))
(s/def ::email-subject (spec-or-ref string?))
(s/def ::sms-message (spec-or-ref string?))

(defmethod ->key :sms-message [_] "SMSMessage")

(s/def ::resource-property-spec (s/keys :opt [::email-message
                                              ::email-subject
                                              ::sms-message]))
