(ns git-revisions.buildtools
  (:require [clojure.java.shell :as sh]
            [clojure.tools.build.api :as build-api]
            [git-revisions.core :as revisions]))

(defn generate-revision
  [configuration]
  (let [project-root (build-api/resolve-path ".")]
    (sh/with-sh-dir project-root
      (let [{:keys [format adjust revision-file]} configuration
            version (revisions/revision-generator format adjust (when (some? revision-file)
                                                                  {:output-path  (build-api/resolve-path revision-file)
                                                                   :project-root project-root}))]
        version))))

