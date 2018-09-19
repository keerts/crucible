(ns crucible.aws.cognito.policies
  "Amazon Cognito Policies, a property of AWS::Cognito::UserPool"
  (:require [clojure.spec.alpha :as s]
            [crucible.aws.cognito.password-policy :as password-policy]
            [crucible.resources :refer [spec-or-ref defresource] :as res]))

(s/def ::password-policy (spec-or-ref ::password-policy/resource-property-spec))

(s/def ::resource-property-spec (s/keys :opt [::password-policy]))
