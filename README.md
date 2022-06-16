# git-revisions for tools.build

[![Deploy to Clojars](https://github.com/esuomi/git-revisions-buildtools/actions/workflows/deploy.yaml/badge.svg)](https://github.com/esuomi/git-revisions-buildtools/actions/workflows/deploy.yaml)
[![Clojars Project](https://img.shields.io/clojars/v/fi.polycode/buildtools-git-revisions.svg)](https://clojars.org/fi.polycode/buildtools-git-revisions)
[![cljdoc badge](https://cljdoc.org/badge/fi.polycode/buildtools-git-revisions)](https://cljdoc.org/jump/release/fi.polycode/buildtools-git-revisions)

Automatically control [tools.build](https://github.com/clojure/tools.build) based project version based on Git and system metadata.

## Usage

 1. **Add suitable base tag to repository**
    ```shell
    git tag -a v0.0.0 -m "initial version"
    ```
 2. **Add plugin definition to `project.clj`**
    ```clojure
    (defproject foo/bar "_"  ; replace project version string with underscore
      ...
      ; add the plugin dependency
      :plugins [[fi.polycode/lein-git-revisions "LATEST"]
                ...]
      ; add recommended default configuration
      :git-revisions {:format        :semver
                      :adjust        [:env/revision_adjustment :minor]
                      :revision-file "resources/metadata.edn"}
      ...)
    ```

> Project version must be a string for IDE compatability. For example Cursive makes assumptions based on the version
> always being a string.

Further configuration options are described in depth at [git-revisions core library's README](https://github.com/esuomi/git-revisions#configuration).

## License

Copyright © 2022 Esko Suomi

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.

