# **OSINT Report**  
**Subject:** RSTA/BCTA (https://bcta.gov.bt/bctaweb/) 
**Date:** 16/03/2025  
**Analyst:** Sonam Tenzin(02230300)  

---

## **1. Summary**  

The Bhutan Construction and Transport Authority (BCTA) was formed on December 30, 2022, by merging the Road Safety and Transport Authority (RSTA) and the Construction Development Board (CDB). This consolidation aims to enhance professionalism and accountability in Bhutan's construction and surface transport sectors.


**Key Functions:**

- **Regulatory Oversight:** Developing, reviewing, and updating rules and regulations to ensure safety and public service standards in construction and surface transport sectors.

- **Service Delivery:** Providing services such as vehicle registration, driving license issuance, and construction professional certifications.

- **Compliance Enforcement:** Conducting compliance audits to uphold safety and quality standards in construction and surface transport sectors.


---

## **2. Methodology**  

- I have used a combination of manual and automated OSINT techniques to gather information about the Bhutan Construction and Transport Authority (BCTA).
- The process involved searching for official websites and other online profiles associated with BCTA.
- I also utilized OSINT tools like `Shodan`, `crt.sh`, and `nslookup.io` to collect data from various online sources.
---

## **3. Findings**  
### **3.1 Digital Footprint**

- IP Address: 43.230.208.21
- Hostnames:	bcta.gov.bt / www.bcta.gov.bt / www.rsta.gov.bt
- Domains:	bcta.gov.bt / rsta.gov.bt 

- Organization:	Ministry of Information & Communications
![alt text](<../assets/Screenshot 2025-03-16 233911.png>)
Upon using Shadon, I have noticed that the IP address has 3 open ports; port 80, 443, and 8080. The website is hosted in Bhutan and the organization is under the Ministry of Information and Communications. The website is also using the HTTP/2 protocol.

![alt text](<../assets/Screenshot 2025-03-16 233938.png>)

![alt text](<../assets/Screenshot 2025-03-16 234027.png>)

![alt text](<../assets/Screenshot 2025-03-16 234115.png>)

![alt text](<../assets/Screenshot (42).png>)
This is one of the RSTA directory that has been found in the website. MinIO stores data as objects in a flat address space, ensuring high scalability and efficiency. It supports erasure coding for data protection, encryption for security, and multi-tenancy for large-scale deployments. MinIO is API-driven and integrates seamlessly with Kubernetes and various cloud storage frameworks. MinIO Console is for administration tasks like Identity and Access Management, Metrics and Log Monitoring, or Server Configuration

![alt text](<../assets/Screenshot (44).png>)
This is the admin web page of the website.

![alt text](<../assets/Screenshot (45).png>)

This website directory is most like the dreiectory of the website in which the highly confidential information is stored since the access to the web page is forbidden.

![alt text](<../assets/Screenshot (46).png>)

![alt text](<../assets/Screenshot (47).png>)

### **3.2 Geolocation**  

- Country:	Bhutan
- City:	Phuntsholing

### **3.3 Threats & Vulnerabilities**  
 
![alt text](<../assets/Screenshot 2025-03-16 234125.png>)

1. **CVE-2023-44487 (Severity: 7.5) - HTTP/2 DoS Attack**  
   - This vulnerability in the HTTP/2 protocol allows attackers to cause a denial-of-service (DoS) attack by rapidly canceling requests, consuming server resources. It was exploited in real-world attacks between August and October 2023.

2. **CVE-2021-3618 (Severity: 7.4) - ALPACA Attack**  
   - This is a TLS-based attack where a man-in-the-middle (MiTM) attacker can exploit different protocols sharing the same TLS certificate (e.g., multi-domain or wildcard certificates). It allows attackers to redirect traffic between subdomains, potentially breaking authentication and enabling cross-protocol attacks.

These vulnerabilities highlight risks related to network security, particularly denial-of-service and TLS exploitation.

---

## **4. Appendices & References**  
43.230.208.21. (n.d.). https://www.shodan.io/host/43.230.208.21

CRt.sh | eralis.rsta.gov.bt. (n.d.). https://crt.sh/?q=eralis.rsta.gov.bt

MinIO Console. (n.d.). https://console-s3.eralis.rsta.gov.bt/login

RSTA. (n.d.). https://admin.eralis.rsta.gov.bt/login

https://report.eralis.rsta.gov.bt/

Website to IP lookup. (n.d.). NsLookup.io. https://www.nslookup.io/domains/bcta.gov.bt/webservers/

BCTA. (n.d.). https://bcta.gov.bt/bctaweb/

AS135666 Government Data Center (DITT/MOIC). (n.d.). https://ipinfo.io/AS135666

---
