package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class GoRestBaseUrl {

    protected RequestSpecification spec;

    @Before
    public void setup() {
        spec = new RequestSpecBuilder().setBaseUri("https://gorest.co.in/public/v1").build();
    }

}

//https://jsonpath.herokuapp.c{
//	"info": {
//		"_postman_id": "26ffe0eb-7296-4eb8-ae09-a6696ac3d3c6",
//		"name": "Batch81",
//		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
//		"_exporter_id": "14360503"
//	},
//	"item": [
//		{
//			"name": "Regres.in",
//			"item": [
//				{
//					"name": "New Request",
//					"request": {
//						"method": "GET",
//						"header": [],
//						"url": {
//							"raw": "https://reqres.in/api/users?page=1",
//							"protocol": "https",
//							"host": [
//								"reqres",
//								"in"
//							],
//							"path": [
//								"api",
//								"users"
//							],
//							"query": [
//								{
//									"key": "page",
//									"value": "1"
//								}
//							]
//						}
//					},
//					"response": []
//				}
//			]
//		},
//		{
//			"name": "Herokuapp",
//			"request": {
//				"method": "GET",
//				"header": [],
//				"url": {
//					"raw": "https://restful-booker.herokuapp.com/booking",
//					"protocol": "https",
//					"host": [
//						"restful-booker",
//						"herokuapp",
//						"com"
//					],
//					"path": [
//						"booking"
//					]
//				}
//			},
//			"response": []
//		},
//		{
//			"name": "GMIBank",
//			"request": {
//				"auth": {
//					"type": "bearer",
//					"bearer": [
//						{
//							"key": "token",
//							"value": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJiYXRjaDgxIiwiYXV0aCI6IlJPTEVfQURNSU4iLCJleHAiOjE2NjcwNjYxMjB9.0PGZYnj1UKSPxJqvYVOIpWLLBTnrAVyKn-vNlRq_JXu8r3B9UqPMtVkF0RkXi12i2XPhuDyGIRNY8H9_hxAoPw",
//							"type": "string"
//						}
//					]
//				},
//				"method": "GET",
//				"header": [],
//				"url": {
//					"raw": "https://www.gmibank.com/api/tp-customers",
//					"protocol": "https",
//					"host": [
//						"www",
//						"gmibank",
//						"com"
//					],
//					"path": [
//						"api",
//						"tp-customers"
//					]
//				}
//			},
//			"response": []
//		},
//		{
//			"name": "https://restful-booker.herokuapp.com/auth",
//			"request": {
//				"method": "POST",
//				"header": [],
//				"body": {
//					"mode": "raw",
//					"raw": "{\n    \"username\" : \"admin\",\n    \"password\" : \"password123\"\n}",
//					"options": {
//						"raw": {
//							"language": "json"
//						}
//					}
//				},
//				"url": {
//					"raw": "https://restful-booker.herokuapp.com/auth",
//					"protocol": "https",
//					"host": [
//						"restful-booker",
//						"herokuapp",
//						"com"
//					],
//					"path": [
//						"auth"
//					]
//				}
//			},
//			"response": []
//		},
//		{
//			"name": "https://www.gmibank.com/api/authenticate",
//			"request": {
//				"method": "POST",
//				"header": [],
//				"body": {
//					"mode": "raw",
//					"raw": "{\n  \"password\": \"Batch81+\",\n  \"rememberMe\": true,\n  \"username\": \"Batch81\"\n}",
//					"options": {
//						"raw": {
//							"language": "json"
//						}
//					}
//				},
//				"url": {
//					"raw": "https://www.gmibank.com/api/authenticate",
//					"protocol": "https",
//					"host": [
//						"www",
//						"gmibank",
//						"com"
//					],
//					"path": [
//						"api",
//						"authenticate"
//					]
//				}
//			},
//			"response": []
//		},
//		{
//			"name": "https://dummy.restapiexample.com/api/v1/employees",
//			"request": {
//				"method": "GET",
//				"header": [],
//				"url": {
//					"raw": "https://dummy.restapiexample.com/api/v1/employees",
//					"protocol": "https",
//					"host": [
//						"dummy",
//						"restapiexample",
//						"com"
//					],
//					"path": [
//						"api",
//						"v1",
//						"employees"
//					]
//				}
//			},
//			"response": []
//		}
//	]
//}om/