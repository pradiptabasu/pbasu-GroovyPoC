import groovyx.net.http.RESTClient
println "Hello"
def file1 = new File('groovy1.txt')
file1.write 'Working with files the Groovy way is easy.\n'
def client1 = new RESTClient( 'http://oa8102.us.oracle.com:7201/' )
def resp1 = client1.get(path : "APICSDemoBackendServicesREST/rest/PublicCalculatorService")
file1.write resp1.getData().text

import groovyx.net.http.HTTPBuilder
String url = 'http://oa8102.us.oracle.com:7201/'
String uriPath = 'APICSDemoBackendServicesREST/rest/PublicCalculatorService'
HTTPBuilder http = new HTTPBuilder(url)
http.get(path:uriPath) { resp, reader ->;
     file1.write reader.text
     println resp.statusLine
}