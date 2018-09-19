(ns crucible.aws.cognito.lambda-config
  "Amazon Cognito SMSConfiguration, a property of AWS::Cognito::UserPool"
  (:require [clojure.spec.alpha :as s]
            [crucible.resources :refer [spec-or-ref defresource] :as res]))

(s/def ::sns-caller-arn (spec-or-ref string?))
(s/def ::external-id (spec-or-ref string?))

(s/def ::create-auth-challenge (spec-or-ref string?))
(s/def ::custom-message (spec-or-ref string?))
(s/def ::define-auth-challenge (spec-or-ref string?))
(s/def ::post-authentication (spec-or-ref string?))
(s/def ::post-confirmation (spec-or-ref string?))
(s/def ::pre-authentication (spec-or-ref string?))
(s/def ::pre-sign-up (spec-or-ref string?))
(s/def ::verify-auth-challenge-response (spec-or-ref string?))

(s/def ::resource-property-spec (s/keys :opt [::create-auth-challenge
                                              ::custom-message
                                              ::define-auth-challenge
                                              ::post-authentication
                                              ::post-confirmation
                                              ::pre-authentication
                                              ::pre-sign-up
                                              ::verify-auth-challenge-response]))
