package com.praveen.android.teams.repository


import com.praveen.android.teams.utility.Utils
import okhttp3.*

class MockInterceptor : Interceptor {


    override fun intercept(chain: Interceptor.Chain): Response {
        val uri = chain.request().url().uri().toString()

        when {
            uri.contains("invites") -> {
                var responseString = ""
                responseString = getPositiveResponseJson
                return chain.proceed(chain.request())
                    .newBuilder()
                    .code(200)
                    .protocol(Protocol.HTTP_2)
                    .message(responseString)
                    .body(
                        ResponseBody.create(
                            MediaType.parse("application/json"),
                            Utils().loadJSONFile("permission.json")?.toByteArray()
                        )
                    )
                    .addHeader("content-type", "application/json")
                    .build()
            }
            uri.contains("teams") and uri.contains("teamId") -> {
                var responseString = ""
                responseString = getPositiveResponseJson
                return chain.proceed(chain.request())
                    .newBuilder()
                    .code(200)
                    .protocol(Protocol.HTTP_2)
                    .message(responseString)
                    .body(
                        ResponseBody.create(
                            MediaType.parse("application/json"),
                            Utils().loadJSONFile("members.json")?.toByteArray()
                        )
                    )
                    .addHeader("content-type", "application/json")
                    .build()
            }

            else -> {
                return chain.proceed(chain.request())
            }
        }

    }

    val getPositiveResponseJson = """
        {
            "response": "Success",
            "code": 200
        }"""


}
