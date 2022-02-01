#!/usr/bin/env bash
helm delete hw2-service --namespace otus-lab
helm delete postgres-lab --namespace otus-lab
minikube kubectl -- delete pvc data-postgres-lab-postgresql-0 --namespace otus-lab
