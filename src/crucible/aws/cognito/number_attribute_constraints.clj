(ns crucible.aws.cognito.number-attribute-constraints
  "Amazon Cognito NumberAttributeConstraints, a subproperty of AWS::Cognito::UserPool SchemaAttribute"
  (:require [clojure.spec.alpha :as s]
            [crucible.resources :refer [spec-or-ref defresource] :as res]))

(s/def ::max-value (spec-or-ref string?))
(s/def ::min-value (spec-or-ref string?))

(s/def ::resource-property-spec (s/keys :opt [::max-value
                                              ::min-value]))
