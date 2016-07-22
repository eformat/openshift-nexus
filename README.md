# Nexus for OpenShift Enterprise 3

This is instant nexus application for OpenShift Enterprise 3.

```
oc new-project nexus --display-name="Nexus" --description="Nexus"
oc new-app -f https://raw.githubusercontent.com/eformat/openshift-nexus/master/nexus.yaml
```
