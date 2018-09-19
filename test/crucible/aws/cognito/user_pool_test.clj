(ns crucible.aws.cognito.user-pool-test
  (:require [crucible.aws.cognito.user-pool :as sut]
            [crucible.core :refer [xref join] :as cf]
            [clojure.spec.alpha :as s]
            [clojure.test :refer :all]))

(deftest user-pool-tests

  (testing "minimum valid user pool"
    (is (s/valid? ::sut/resource-spec
                  {::sut/user-pool-name "admins"}))))
