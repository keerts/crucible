(ns crucible.aws.cognito.admin-create-user-config
  "Amazon AdminCreateUserConfig, a property of AWS::Cognito::UserPool"
  (:require [clojure.spec.alpha :as s]
            [crucible.aws.cognito.invite-message-template :as invite-message-template]
            [crucible.resources :refer [spec-or-ref defresource] :as res]))

(s/def ::allow-admin-create-user-only (spec-or-ref boolean?))
(s/def ::invite-message-template (spec-or-ref ::invite-message-template/resource-property-spec))
(s/def ::unused-account-validity-days (spec-or-ref integer?))

(s/def ::resource-property-spec (s/keys :opt [::allow-admin-create-user-only
                                              ::invite-message-template
                                              ::unused-account-validity-days]))
