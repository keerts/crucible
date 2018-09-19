(ns crucible.aws.cognito
  "Resources in AWS::Cognito::*"
  (:require [crucible.aws.cognito.user-pool :as user-pool]
            [crucible.resources :refer [spec-or-ref defresource] :as res]))

(defn prefix [suffix] (str "AWS::Cognito::" suffix))

(defresource user-pool (prefix "UserPool") ::user-pool/resource-spec)
