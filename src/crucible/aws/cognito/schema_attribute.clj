(ns crucible.aws.cognito.schema-attribute
  "Amazon Cognito SchemaAttribute, a property of AWS::Cognito::UserPool"
  (:require [clojure.spec.alpha :as s]
            [crucible.aws.cognito.number-attribute-constraints :as number-attribute-constraints]
            [crucible.aws.cognito.string-attribute-constraints :as string-attribute-constraints]
            [crucible.resources :refer [spec-or-ref defresource] :as res]))

(s/def ::attribute-data-type (spec-or-ref string?))
(s/def ::developer-only-attribute (spec-or-ref boolean?))
(s/def ::mutable (spec-or-ref boolean?))
(s/def ::name (spec-or-ref string?))
(s/def ::number-attribute-constraints (spec-or-ref ::number-attribute-constraints/resource-property-spec))
(s/def ::string-attribute-constraints (spec-or-ref ::string-attribute-constraints/resource-property-spec))
(s/def ::required (spec-or-ref boolean?))

(s/def ::resource-property-spec (s/keys :opt [::attribute-data-type
                                              ::developer-only-attribute
                                              ::mutable
                                              ::name
                                              ::number-attribute-constraints
                                              ::string-attribute-constraints
                                              ::required]))
