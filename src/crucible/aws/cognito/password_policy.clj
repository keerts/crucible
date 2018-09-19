(ns crucible.aws.cognito.password-policy
  "Amazon Cognito PasswordPolicy, a subproperty of AWS::Cognito::UserPool Policies"
  (:require [clojure.spec.alpha :as s]
            [crucible.resources :refer [spec-or-ref defresource] :as res]))

(s/def ::minimum-length (spec-or-ref integer?))
(s/def ::require-lowercase  (spec-or-ref boolean?))
(s/def ::require-numbers (spec-or-ref boolean?))
(s/def ::require-symbols (spec-or-ref boolean?))
(s/def ::require-uppercase (spec-or-ref boolean?))

(s/def ::resource-property-spec (s/keys :opt [::minimum-length
                                              ::require-lowercase
                                              ::require-numbers
                                              ::require-symbols
                                              ::require-uppercase]))
