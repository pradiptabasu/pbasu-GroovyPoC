/*
def name='prabasu'
println "Hello $name!"
*/

import groovyx.net.http.RESTClient
 
/* * 

def client = new RESTClient( 'http://oa8102.us.oracle.com:7201/' )
def resp = client.get(path : "APICSDemoBackendServicesREST/rest/PublicCalculatorService")

assert resp.status == 200  // HTTP response code; 404 means not found, etc.
println resp.contentType
println resp.data
println resp.status
println resp.headers.Status
println resp.data.text

def client1 = new RESTClient( 'http://oa8102.us.oracle.com:7201/' )
def resp1 = client1.get(path : "APICSDemoBackendServicesREST/rest/PublicCalculatorService")
println resp1.getData().text


def num1=4
def num2=5
def client2 = new RESTClient( 'http://oa8102.us.oracle.com:7201/' )
def resp2 = client2.get(path : 'APICSDemoBackendServicesREST/rest/PublicCalculatorService/multiply/$num1/$num2')
println resp2.getData().text

**/


def numberPOST1=9
def numberPOST2=6
def clientPOST = new RESTClient( 'http://oa8102.us.oracle.com:7201/' )
def respPOST = clientPOST.post( path : 'APICSDemoBackendServicesREST/rest/PublicCalculatorService/multiply',
                                body : [ num1:numberPOST1, num2:numberPOST2 ],
                                requestContentType: 'application/json',
                                contentType: 'text/plain'
                            )
println respPOST.getData().text