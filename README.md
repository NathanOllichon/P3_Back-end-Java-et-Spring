# WARN front by Openclassroom not work properly

- Misstake in DB generation
- Front issue for access to create rentals form

use https://github.com/NathanOllichon/P3_OC_Front_Fixed

# Estate

This project was generated with:

- eclipse IDE - Version: 2023-03 (4.27.0)
- lombock lest version, need to execute the jar lombock on our desktop.
- MySQL Server 8.0

# Docmentation

http://localhost:3001/api/documentation.html

# Intall and run project

- First go in eclipse and import project at existing maven project.

- Generate RSA keys in certs folder (public.pem, private.pem).

- Go to MySQL command line, when your connecter use "source [Project_Folder]/Developpez-le-back-end-en-utilisant-Java-et-Spring/ressources/sql/script.sql;".

- in Eclipse run project at SpringBoot configuration without profile.

# Generate RSA keys Windows/cmder-console exemple

#go in folder
cd [pathToProjet]/P3_Back-end-Java-et-Spring/src/main/resources/certs/

#create rsa key pair
openssl genrsa -out keypair.pem 2048

#extract public key
openssl rsa -in keypair.pem -pubout -out public.pem

#create private key in PKCS#8 format
openssl pkcs8 -topk8 -inform PEM -outform PEM -nocrypt -in keypair.pem -out private.pem
