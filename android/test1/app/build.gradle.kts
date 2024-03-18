import com.android.build.api.dsl.ViewBinding

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.bitc.test1" //패키지명
    compileSdk = 34//사용할 안드로이드 SDK 버전(API34 = 안드로이드 14버전)

    defaultConfig {
        applicationId = "com.bitc.test1"
        minSdk = 26 //안드로이드 SDK 최소 지원 버전 (API 26 = 안드로이드 8.0버전)
        targetSdk = 34
        versionCode = 1
        versionName = "1.0" //신경X

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        //자바 8버전 기준
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
//    뷰 바인딩 사용하기
    viewBinding {
    enable = true}
}
//의존성 라이브러리
dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}