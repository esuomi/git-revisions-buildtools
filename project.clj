(defproject fi.polycode/buildtools-git-revisions "_"
  :description "Automatically control tools.build based project version based on Git and system metadata."
  :url "https://github.com/esuomi/git-revisions-buildtools"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}

  :scm {:name "git" :url "https://github.com/esuomi/git-revisions-buildtools"}

  :dependencies [[fi.polycode/git-revisions "1.2.2"]
                 [clojure/tools.build "ba1a2bf421838802e7bdefc541b41f57582e53b6" :scope "provided"]]

  :repositories [["public-github" {:url "git://github.com"}]]

  :deploy-repositories [["clojars" {:sign-releases false
                                    :url           "https://clojars.org/repo"
                                    :username      :env/CLOJARS_USERNAME
                                    :password      :env/CLOJARS_TOKEN}]]

  :global-vars {*warn-on-reflection* true}

  :plugins [[fi.polycode/lein-git-revisions "LATEST"]
            [lein-pprint "1.3.2"]
            [reifyhealth/lein-git-down "0.4.1"]]

  :profiles {:dev {:dependencies [[lambdaisland/kaocha "1.64.1010"]
                                  [lambdaisland/kaocha-cloverage "1.0.75"]]}}

  :git-revisions {:format        :semver
                  :adjust        [:env/BUILDTOOLS_REVISIONS_ADJUSTMENT :minor]
                  :revision-file "resources/metadata.edn"}

  :aliases {"kaocha" ["run" "-m" "kaocha.runner"]})
