-package com.android.study.jetpack_compose_lab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.study.jetpack_compose_lab.ui.theme.Jetpack_Compose_LabTheme

class MainActivity : ComponentActivity() { //ComponentActivity 를 상속해 Compose 기반 UI 를 사용할 수 있게 함
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { //컴포즈 UI 시작 블록
            Jetpack_Compose_LabTheme { // 커스텀 테마 (색상, 폰트 등)
                // Material 디자인 구조를 위한 기본 레이아웃
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding -> // scaffold 의 내부 padding 을 적용해 UI 요소가 겹치지 않도록 함
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// param 으로 받은 이름을 이용해 텍스트 출력
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) { //Modifier 을 기본값으로 받게 함 -> 유연성 확보 (호출 시 Modifier 를 전달하지 않아도 함수가 동작할 수 있고, 원할때 필요 위치에서만 modifier 적용 가능)

    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true) // UI 를 미리보기 할 수 있게 함. (배경 보이게)
@Composable
fun GreetingPreview() {
    Jetpack_Compose_LabTheme {
        Greeting("Android")
        Greeting("Android", Modifier.padding(16.dp)) // padding 을 적용한 예시
    }
}