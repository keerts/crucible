(ns crucible.aws.elbv2.listener-certificate
  "AWS::ElasticLoadBalancingV2::Listener"
  (:require [clojure.spec.alpha :as s]
            [crucible.aws.elbv2 :as elbv2]
            [crucible.resources :refer [spec-or-ref defresource] :as res]))

(s/def ::certificate-arn (spec-or-ref string?))
(s/def ::certificate (s/keys :req [::certificate-arn]))
(s/def ::certificates (s/* ::certificate))
(s/def ::listener-arn (spec-or-ref string?))
(s/def ::listener-certificate-spec (s/keys :req [::certificates
                                                 ::listener-arn]))

(defresource listener-certificate (elbv2/prefix "ListenerCertificate") ::listener-certificate-spec)
