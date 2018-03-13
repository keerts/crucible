(ns crucible.aws.ecs
  "Resources in AWS::ECS::*"
  (:require [clojure.spec.alpha :as s]
            [crucible.encoding.keys :refer [->key]]
            [crucible.resources :as res :refer [defresource spec-or-ref]]))

(defn ecs [suffix] (str "AWS::ECS::" suffix))

;; cluster http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-ecs-cluster.html

(s/def ::cluster-name (spec-or-ref string?))
;; call this cluster-spec to keep the cluster property below simple
(s/def ::cluster-spec (s/keys :opt [::cluster-name]))

(defresource cluster (ecs "Cluster") ::cluster-spec)

;; service http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-ecs-service.html

;; (s/def ::crucible.aws.ecs.placement-constraint/type string?) ;; used in both placement-constraint and placement-strategy, what if we need to spec further?
(s/def ::type string?) ;; used in both placement-constraint and placement-strategy, what if we need to spec further?
(s/def ::field (spec-or-ref string?))
(s/def ::expression (spec-or-ref string?))
(s/def ::placement-constraint (s/keys :req [::type ::expression]))
(s/def ::placement-strategy (s/keys :req [::type ::field]))
(s/def ::maximum-percent (spec-or-ref integer?))
(s/def ::minimum-healthy-percent (spec-or-ref integer?))
(s/def ::container-name (spec-or-ref string?))
(s/def ::container-port (spec-or-ref integer?))
(s/def ::load-balancer-name (spec-or-ref string?))
(s/def ::target-group-arn (spec-or-ref string?))
(s/def ::assign-public-ip #{"ENABLED" "DISABLED"})
(s/def ::security-groups (s/* (spec-or-ref string?)))
(s/def ::load-balancer (s/keys :req [::container-name
                                     ::container-port]
                               :opt [::load-balancer-name
                                     ::target-group-arn]))
(s/def ::aws-vpc-configuration (s/keys :req [::subnets]
                                       :opt [::assign-public-ip
                                             ::security-groups]))

(defmethod ->key :aws-vpc-configuration [_] "AwsvpcConfiguration")

(s/def ::cluster (spec-or-ref string?))
(s/def ::deployment-configuration (s/keys :req [::maximum-percent
                                                ::minimum-healthy-percent]))
(s/def ::desired-count (spec-or-ref integer?))
(s/def ::launch-type (spec-or-ref string?))
(s/def ::load-balancers (s/* ::load-balancer))
(s/def ::network-configuration (s/keys :opt [::aws-vpc-configuration]))
(s/def ::placement-constraints (s/* ::placement-constraint))
(s/def ::role (spec-or-ref string?))
(s/def ::placement-strategies (s/* ::placement-strategy))
(s/def ::platform-version (spec-or-ref string?))
(s/def ::service-name (spec-or-ref string?))
(s/def ::task-definition (spec-or-ref string?))
(s/def ::service (s/keys :req [::task-definition]
                         :opt [::cluster
                               ::deployment-configuration
                               ::desired-count
                               ::launch-type
                               ::load-balancers
                               ::network-configuration
                               ::placement-constraint
                               ::placement-strategies
                               ::platform-version
                               ::role
                               ::service-name]))

(defresource service (ecs "Service") ::service)

;; task http://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-ecs-taskdefinition.html

(s/def ::name (spec-or-ref string?))

;; container spec (TODO incomplete)

(s/def ::memory (spec-or-ref integer?))
(s/def ::container-port (spec-or-ref integer?))
(s/def ::host-port (spec-or-ref integer?))
(s/def ::protocol (spec-or-ref string?))
(s/def ::port-mapping (s/keys :req [::container-port]
                              :opt [::host-port
                                    ::protocol]))
(s/def ::port-mappings (s/* ::port-mapping))
(s/def ::image (spec-or-ref string?))
(s/def :crucible.aws.ecs.task-definition.key-value-pair/name (spec-or-ref string?))
(s/def :crucible.aws.ecs.task-definition.key-value-pair/value (spec-or-ref string?))
;; todo prefix as well?
(s/def ::key-value-pair (s/keys :req [:crucible.aws.ecs.task-definition.key-value-pair/name
                                      :crucible.aws.ecs.task-definition.key-value-pair/value]))
(s/def ::environment (spec-or-ref (s/* ::key-value-pair)))
(s/def ::command (spec-or-ref string?))
(s/def ::cpu (spec-or-ref integer?))
(s/def :crucible.aws.ecs.log-configuration/log-driver (spec-or-ref string?))
(s/def :crucible.aws.ecs.log-configuration/options map?)
(s/def ::log-configuration (s/keys :req [:crucible.aws.ecs.log-configuration/log-driver]
                                   :opt [:crucible.aws.ecs.log-configuration/options]))
(s/def ::container-definition (s/keys :req [::name
                                            ::image]
                                      :opt [::memory
                                            ::environment
                                            ::port-mappings
                                            ::command
                                            ::cpu
                                            ::log-configuration]))

(s/def ::source-path (spec-or-ref string?))
(s/def ::host (s/keys :opt [::source-path]))
(s/def ::volume (s/keys :req [::name ::host]))

(s/def ::cpu #{256 512 1024 2048 4096})
(s/def ::execution-role-arn (spec-or-ref string?))
(s/def ::family (spec-or-ref string?))
(s/def ::memory (spec-or-ref integer?))
(s/def ::network-mode #{"bridge" "host" "awsvpc" "none"})
(s/def ::requires-compatibility (spec-or-ref string?))
(s/def ::requires-compatibilities (s/* ::requires-compatibility))
(s/def ::task-role-arn (spec-or-ref string?))
(s/def ::volumes (s/* ::volume))
(s/def ::container-definitions (s/* ::container-definition))

;; call this ...-spec to keep the task-definition property simple
(s/def ::task-definition-spec (s/keys :req [::container-definitions]
                      :opt [::cpu
                            ::execution-role-arn
                            ::family
                            ::memory
                            ::network-mode
                            ::placement-constraints
                            ::requires-compatibilities
                            ::task-role-arn
                            ::volumes]))

(defresource task-definition (ecs "TaskDefinition") ::task-definition-spec)