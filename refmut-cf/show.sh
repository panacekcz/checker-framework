#!/usr/bin/bash
../checker/bin/javac -Awarns -processor org.checkerframework.checker.refmut.RefmutChecker -d out src/Defaults.java || exit 1
cd out
CLASSPATH=".:../../checker/dist/checker-qual.jar" ../../../annotation-tools/annotation-file-utilities/scripts/extract-annotations Defaults || exit 1
cat Defaults.jaif