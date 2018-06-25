# Nexus for OpenShift Enterprise 3

This is instant nexus application for OpenShift Enterprise 3.

Install nexus

```
oc new-project nexus --display-name="Nexus" --description="Nexus"
oc new-app -f https://raw.githubusercontent.com/eformat/openshift-nexus/master/nexus.yaml

```

Configure nexus

```
ansible-playbook -i inventory ocp-nexus-configure.yml
```
