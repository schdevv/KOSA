#### 2023.04.05

### 1. ANN(Artificial Neural Network) 인공신경망

#### 0. import Modules

|구분|속성(함수)명|설명|
|---|---|---|
|1|import numpy as np |다차원 배열 library (ndarray) |
|2|import pandas as pd|데이터 처리와 분석을 위한 library|
|3|import matplotlib.pyplot as plt|그래프 표현을 위한 library|
|4|import tensorflow as tf|계산 구조와 목표 함수만 정의하면 자동으로 미분 계산을 처리|
|5|from sklearn.preprocessing import MinMaxScaler||
|6|from sklearn.model_selection import train_test_split||
|7|from tensorflow.keras.models import Sequential||
|8|from tensorflow.keras.layers import Flatten, Dense, Conv2D, MaxPooling2D, Dropout||
|9|from tensorflow.keras.optimizers import Adam, RMSprop||
|9|import matplotlib.pyplot as plt||


 
#### 0. Raw Data Loading

|구분|속성(함수)명|설명|
|---|---|---|
|1|.read_csv||
|2|.head()||
|3|.shape||

  
#### 0. Image data define

|구분|속성(함수)명|설명|
|---|---|---|
|1|.values||
|2|axis=||
|3|inplace=||
  
#### 0. data split

|구분|속성(함수)명|설명|
|---|---|---|
|1|train_test_split()||
|2|test_size=||
|3|random_state=||


#### 0. 정규화 처리

|구분|속성(함수)명|설명|
|---|---|---|
|1|MinMaxScaler()||
|2|fit()||
|3|scaler.transform||

#### 0. Model

|구분|속성(함수)명|설명|
|---|---|---|
|1|Sequential()||
|2|Conv2D||
|3|filters||
|4|kernel_size=||
|5|padding=||
|6|input_shape=||
|7|MaxPooling2D||
|8|pool_size=||

#### 0. Layer attribute

|구분|속성(함수)명|설명|
|---|---|---|
|1|relu||
|2|sigmoid||
|3|initializer||
|4|units=||
|5|rate=||
|6|summary()||
|7|activation=||
|8|||

#### 0. Trnasfer Learning

|구분|속성(함수)명|설명|
|---|---|---|
|1|include_top=False||
|2|input_shape=()|input Image data의 형태를 지정해줌|
|3|initializer||
|4|units=||
|5|rate=||
|6|summary()||
|7|activation=||
|8|||