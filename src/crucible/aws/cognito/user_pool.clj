(ns crucible.aws.cognito.user-pool
  "AWS::Cognito::UserPool"
  (:require [clojure.spec.alpha :as s]
            [crucible.aws.cognito.admin-create-user-config :as admin-create-user-config]
            [crucible.aws.cognito.device-configuration :as device-configuration]
            [crucible.aws.cognito.email-configuration :as email-configuration]
            [crucible.aws.cognito.sms-configuration :as sms-configuration]
            [crucible.aws.cognito.lambda-config :as lambda-config]
            [crucible.aws.cognito.policies :as policies]
            [crucible.aws.cognito.schema-attribute :as schema-attribute]
            [crucible.resources :refer [spec-or-ref] :as res]))

(s/def ::user-pool-name (spec-or-ref string?))
(s/def ::admin-create-user-config (spec-or-ref ::admin-create-user-config/resource-property-spec))
(s/def ::alias-attributes (s/coll-of string? :kind vector))
(s/def ::auto-verified-attributes (s/coll-of string? :kind vector))
(s/def ::device-configuration (spec-or-ref ::device-configuration/resource-property-spec))
(s/def ::email-configuration (spec-or-ref ::email-configuration/resource-property-spec))
(s/def ::email-verification-message (spec-or-ref string?))
(s/def ::email-verification-subject (spec-or-ref string?))
(s/def ::lambda-config (spec-or-ref ::lambda-config/resource-property-spec))
(s/def ::mfa-configuration (spec-or-ref string?))
(s/def ::policies (spec-or-ref ::policies/resource-property-spec))
(s/def ::schema (s/coll-of ::schema-attribute/resource-property-spec :kind vector))
(s/def ::sms-authentication-message (spec-or-ref string?))
(s/def ::sms-configuration (spec-or-ref ::sms-configuration/resource-property-spec))
(s/def ::sms-verification-message (spec-or-ref string?))
(s/def ::user-name-attributes (s/coll-of string? :kind vector))
(s/def ::user-pool-tags (s/map-of string? string?))

(s/def ::resource-spec (s/keys :req [::user-pool-name]
                               :opt [::admin-create-user-config
                                     ::alias-attributes
                                     ::auto-verified-attributes
                                     ::device-configuration
                                     ::email-configuration
                                     ::email-verification-message
                                     ::email-verification-subject
                                     ::lambda-config
                                     ::mfa-configuration
                                     ::policies
                                     ::schema
                                     ::sms-authentication-message
                                     ::sms-configuration
                                     ::sms-verification-message
                                     ::user-name-attributes
                                     ::user-pool-tags]))
