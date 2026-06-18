[1mdiff --git a/src/main/java/edu/unl/cc/succession/business/TermBasedSuccession.java b/src/main/java/edu/unl/cc/succession/business/TermBasedSuccession.java[m
[1mindex 049bd1a..60dee68 100644[m
[1m--- a/src/main/java/edu/unl/cc/succession/business/TermBasedSuccession.java[m
[1m+++ b/src/main/java/edu/unl/cc/succession/business/TermBasedSuccession.java[m
[36m@@ -16,7 +16,7 @@[m [mpublic abstract class TermBasedSuccession implements Successionable, Printable {[m
 [m
     protected Integer validateLimit(Number value, String label) {[m
         if (value == null) {[m
[31m-            throw new IllegalArgumentException(label + " cannot be null");[m
[32m+[m[32m            throw new IllegalArgumentException(label + " cannoggit pult be null");[m
         }[m
         if (value instanceof Integer) {[m
             if (value.intValue() < 0) {[m
