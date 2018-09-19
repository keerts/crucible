(ns crucible.aws.cognito.string-attribute-constraints
  "Amazon Cognito StringAttributeConstraints, a subproperty of AWS::Cognito::UserPool SchemaAttribute"
  (:require [clojure.spec.alpha :as s]
            [crucible.resources :refer [spec-or-ref defresource] :as res]))

(s/def ::max-length (spec-or-ref string?))
(s/def ::min-length (spec-or-ref string?))

(s/def ::resource-property-spec (s/keys :opt [::max-length
                                              ::min-length]))
