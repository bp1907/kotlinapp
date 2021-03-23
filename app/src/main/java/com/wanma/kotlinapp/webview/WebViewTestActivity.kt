package com.wanma.kotlinapp.webview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.wanma.kotlinapp.R
import kotlinx.android.synthetic.main.activity_web_view_test.*
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

class WebViewTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view_test)

//        webView.settings.javaScriptEnabled = true
//        webView.webViewClient = WebViewClient()
//        webView.loadUrl("https://www.baidu.com")

        sendRequest.setOnClickListener {
            sendRequestWithHttpURLConnection()
            sendRequestWithOKHttp()
        }

    }

    private fun sendRequestWithOKHttp() {
        val okHttpClient = OkHttpClient.Builder().build()
        val request = Request.Builder().url("").build()
        val response = okHttpClient.newCall(request).execute()
    }

    private fun sendRequestWithHttpURLConnection() {
        thread {
            var connection: HttpURLConnection? = null

            try {
                val response = StringBuilder()
                val url = URL("https://www.baidu.com")
                connection = url.openConnection() as HttpURLConnection
                connection.requestMethod = "GET"
                val input = connection.inputStream
                val reader = BufferedReader(InputStreamReader(input))
                reader.use {
                    reader.forEachLine {
                        response.append(it)
                    }
                }
                showResponse(response.toString())
            }catch (e: Exception) {
                e.printStackTrace()
            }finally {
                connection?.disconnect()
            }
        }
    }

    private fun showResponse(s: String) {
        runOnUiThread {
            responseText.text = s
        }
    }


}