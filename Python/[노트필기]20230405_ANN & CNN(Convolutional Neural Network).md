#### 2023.04.05

### 1. ANN(Artificial Neural Network) 인공신경망
  #### 0) AI 복습(정형 데이터)
```
  (1) Linear Regression : 종속변수가 연속적인 숫자값
    □ 학습데이터의 상태(종속변수)가 변함

  (2) Logistic Regression : 학습데이터의 상태(종속변수)가 다시 변함
    □ binary classification : 0~1사이의 확률값 1개가 도출됨.
    □ Multinomial Classification : class별 확률값이 도출됨(1=> 0.6 / 0.3 / 0.1)
```   
  #### 1) ANN(Artificial Neural Network) 인공신경망 
```
  (1) 이해하기 쉬운 학습방법 : Keras Model을 기본으로 생각하기
    □ DNN(Deep Neural Network) : Layer를 추가한 학습방식 input <- (hidden Layer) -> output 
    □ Layer들간의 Data의 이동통로(hole) : Unit(=Node)
    □ 마케팅적인 측면에서 Deep Learning으로 명명, "알파고" 
    □ Image를 DNN을 이용해서 학습하면 효과적일 것이라는 의견 => 공간지각능력이 없음
      ● Image는 2차원 형태임(Pixel) → 2차원이 여러개 있으므로 학습데이터는 3차원 형태가 됨
      ● 이미지입력 → 기본적으로 3차원
      ● DNN은 입력이 2차원
      ● 해결책 : CNN 
```
```
  (2) 비정형 데이터의 대표격인 Image 파일의 특성
    □ 이미지의 기본 형태는 3차원 data : 가로, 세로, color([R: 10][G: 150][B: 20])
    □ Gray -scale image(흑백) data : 가로 ~, 세로 ~, clolr([R: 60][G: 60][B: 60]) : 평균치
    □ Gray -scale image(흑백) data의 2차원적인 표현법

  (3) Pixel의 단위 : 칸
    □ 1칸 단위당 2의 8승 / 0~255까지 표기
    □ 3칸의 pixel [R][G][B] : 24bit의 True color
    □ 4칸의 piexl [R][G][B][] : 투명도를 더해 다채로운 색상을 구현한 JPG, GIF, PNG 형식
```  
```
  (4) 데카르트 좌표계 (표기방식: x,y)
```
![](2023-04-05-09-41-42.png)

```
  (5) Image 좌표계 (표기방식: y,x)
```
![](2023-04-05-09-56-55.png)
```
  (6) 학습방법
    □  CNN (Convolutional Neural Network) : 합성곱 신경망 → Convnet(컨브넷)
```

  #### 2) CNN (Convolutional Neural Network) : 합성곱 신경망 → Convnet(컨브넷)

![](2023-04-05-17-11-32.png)

```
  (1) Feature Extraction(특성추출) 입력이미지 데이터를 전처리 하는 과정 : input data →  [ input Layer → convoluction Layer conv[] relu함수를 사용해 값을 변동시킴. → pooling Layer (옵션값) →  ] 
  →  Layer(Flatten(=input) / hidden(옵션값, 많이 사용해야 1개) / Output(Dense)) →  예측 <- loss ->정답 비교
  (2) 정의 : f, g 2개의 함수 f를 반전, 전이시켜서 g와 곱한 다음, 그 결과를 적분하는 행위
  (3) 목표 : 사람이 바라보는 개념의 특징들만으로 도출하는 것에서 착안했고 이미지의 특징을 분석하는 것(특징 유추)
  ```

![](2023-04-05-17-12-30.png)
  ```
  (4) convoluction(합성곱연산) : 이미지의 특징을 뽑아내서 학습에 좋은 이미지로 만드는 것
    □ Image Pixel Data(5x5)와 Filter(3x3)의 합성곱 연산 : 같은 위치의 원소끼리 곱한 다음, 전부 합산함.
    □ 한칸씩 이동하면서 반복 => 총 9가지의 결과값은 3x3행렬로 도출함.
    □ Filter(kernel)에 따라 골라지고 여러개의 Filter를 사용함.
    □ 이미지 1개 → 특징만 추출한 이미지 여러개로 만들어짐. 
    □ 원래의 이미지에서 사이즈가 약간 감소하게됨.
    □ 너무 많은 양의 데이터가 생성됨(이미지 사이즈가 약간 줄어듦)
    □ 이 문제를 해결하기 위해 Image size를 강제로 줄일 수 있음(pooling Layer의 작업)
    □ 예측과 결과를 비교한 값인 loss의 값이 적정하지 않다면 다시 반복 수행한다.
    □ Filter가 좋다면, 학습하기 좋은 형태의 이미지를 뽑아낼 수 있음 
```
```
 (5) Filter(kernel) : 보통 3x3형식이 주로 사용됨
  □ Stride : Filter의 칸 이동 반복 행위 (1칸, 2칸, N칸 지정해서 이동이 가낭함, 단N의 값이 클 수록 이동 간격이 넓으므로 도출되는 값이 떨어짐)
  □ Filter를 하나만 이용한다면? 학습을 위해 Image Piexl Data를 변화시켜 여러 case를 생성하고 데이터의 양은 늘리면 학습 효율이 증가함, 그리고 합성곱을 통해 data의 용량은 줄임 
```

```
 (6) Padding : Image Pixel Data를 일부로 확장시킴
  □ 합성곱의 연산을 수행하고나면 Image pixel Data가 작아짐, 거듭할수록 작아진다.
  □ 사용하는 이유? 데이터 전처리를 통해 데이터 형식이 줄어들지 않도록 조치하는 방식
  □ Zero Padding : 5x5를 7x7로 확장시킴 (주입값은 모두 0)
```

![](2023-04-05-17-12-56.png)
```
  (7) MAX pooling ㅣ Image에 Filter를 거쳐서 특징을 뽑아낸 이미지 (Feature Map)
    □ kernel(2x2)(=거름망)를 Stride(2)(=이동경로 2칸 움직임.)
    □ 특징을 뽑아냈으면 결국 같은 그림이 됨, 코드로 확인하기.
```
```
  (8) CNN을 이용해서 Model을 학습하면 Image 학습, 예측에 좋은 결과를 얻을 수 있음.
    □ 데이터는 어떤 형태로 입력해야 하나요?
    □ Model을 어떻게 만드나요? Keras
    □ Model 학습, 평가는요? keras
    □ 실사 데이터를 이용해 학습 & 예측하는 방법은? 전의학습
```

  #### 2) Google Colab을 통한 실습
  ```
   □ 기본설정(리소스 속도 향상을 위한 런타임 변경)
   □ 폴더 → 리소스 → 런타임 유형 변경 → 노트 설정 → 하드웨어 가속시 → None(→ GPU 또는 TPU로 변경) → Google Drive 마운트
  ```

##### (1) CNN 실습 : 이미지 흑백 변환
```python
import numpy as np
from PIL import Image # 이미지처리하기 편한 라이브러리
import matplotlib.pyplot as plt

color_img = Image.open('/content/drive/MyDrive/[파이썬 실습]/fruits.jpg')

plt.imshow(color_img)
plt.show()

# 이 이미지가 3차원 데이터인지 확인하는 방법 : ndarray

color_pixel = np.array(color_img)

# pixel 데이터를 이용해서 그림을 그리는 방법
plt.imshow(color_pixel)
plt.show()
print(color_pixel.shape)
```
![](2023-04-05-17-36-21.png)

```python
# 위의 그림을 흑백으로 변경
# 각 pixel의 RGB값을 평균내서 RGB칸에다 설정하면 흑백처리가 됨

gray_pixel = color_pixel.copy()

#위에서부터 아래로 떨어지니 [0]번째 값은, y임. (좌표값 : y,x,color)
for y in range(gray_pixel.shape[0]):
  for x in range(gray_pixel.shape[1]):
   gray_pixel[y,x] =  np.mean(gray_pixel[y,x]) #indexing : 특정 pixel

plt.imshow(gray_pixel)
plt.show()

print(gray_pixel.shape)

# 흑백은 3차원으로 하는 것보다 2차원으로 표현하면 사이즈를 줄일 수 있어요 

# 3차원 흑백은 RGB값이 모두 평균값으로써 동일한 상태임.

gray_2d_pixel = gray_pixel[:,:,0]
print(gray_2d_pixel.shape)

# 이미지를 2차원으로 바꿨으니 출력해봄.
# cmap = 그래픽 라이브러리에 2차원으로 만든 이미지라고 통보
plt.imshow(gray_2d_pixel, cmap='gray')
plt.show()
```
![](2023-04-05-17-36-58.png)

##### (2) CNN실습 : Feature Extraction(특성추출)
```python
import numpy as np
import tensorflow as tf
import matplotlib.pyplot as plt
import matplotlib.image as img

# 도화지를 준비
fig = plt.figure(figsize=(10,10))  # 가로세로 크기 inch단위

#도화지를 두 부분으로 구분 ( , 2 , ) / 세 부분이면 ( , 3 , )
ax1 = fig.add_subplot(1,2,1)
ax2 = fig.add_subplot(1,2,2)

ori_image = img.imread('/content/drive/MyDrive/[파이썬 실습]/girl-teddy.jpg')

print(ori_image.shape)

# 입력이미지의 형태
# (1, 429, 640, 3) => 4차원(이미지 개수, height, width, color= 3은 chanel이라고도 부름)
input_image = ori_image.reshape((1,) + ori_image.shape)
input_image = input_image.astype(np.float32)
print('Convolution input image.shape : {}'.format(input_image.shape))

# 입력이미지 channel 변경
# (1, 429, 640, 1) => (이미지 개수, height, width, color)
# slicing을 이용하여 첫번째 R(Red) 값만 이용
channel_1_input_image = input_image[:,:,:,0:1]
print('Channel 변경 input_image.shape : {}'.format(channel_1_input_image.shape))

# filter(kernel)
# (3,3,1,1) => (filter height, filter width, filter channel, filter 개수)

weight = np.array([[[[-1]],[[0]],[[1]]],
                   [[[-1]],[[0]],[[1]]],
                   [[[-1]],[[0]],[[1]]]])
print('적용할 filter shape : {}'.format(weight.shape))

conv2d = tf.nn.conv2d(channel_1_input_image,
                      weight,
                      strides=[1,1,1,1],
                      padding='VALID').numpy()
# tensorflow가 제공하고 있는 합성곱 / VALID =채우지 않겠다.

print('Convolution 결과 shape : {}'.format(conv2d.shape))
# 원본 이미지 : input_image.shape : (1, 429, 640, 1) / 수행결과 pixel이 줄어듦이 확인 됨.

t_img = conv2d[0,:,:,:]
ax2.imshow(t_img)

ax1.imshow(ori_image)
fig.tight_layout()
plt.show()

```
![](2023-04-05-17-40-18.png)

```python
# 이번에는 방금 곰소녀 이미지를 이용해 pooling 처리까지 수행해보기

import numpy as np
import tensorflow as tf
import matplotlib.pyplot as plt
import matplotlib.image as img

# 도화지
fig = plt.figure(figsize=(10,10))  # 가로세로 크기 inch단위

# 1행 3열 => 가로로 그림판 3개 작성한다.
ax1 = fig.add_subplot(1,3,1)
ax2 = fig.add_subplot(1,3,2)
ax3 = fig.add_subplot(1,3,3)

ori_image = img.imread('/content/drive/MyDrive/[파이썬 실습]/girl-teddy.jpg')

# 첫번째 그림판에는 이미지 원본을 출력
ax1.imshow(ori_image)

# 입력이미지의 형태
# (1, 429, 640, 3) => (이미지 개수, height, width, color)
input_image = ori_image.reshape((1,) + ori_image.shape)
input_image = input_image.astype(np.float32)
print('Convolution input image.shape : {}'.format(input_image.shape))

# 입력이미지 channel 변경
# (1, 429, 640, 1) => (이미지 개수, height, width, color)
# slicing을 이용하여 첫번째 R(Red) 값만 이용
channel_1_input_image = input_image[:,:,:,0:1]
print('Channel 변경 input_image.shape : {}'.format(channel_1_input_image.shape))


# filter
# (3,3,1,1) => (filter height, filter width, filter channel, filter 개수)
# weight = np.random.rand(3,3,1,1)
weight = np.array([[[[-1]],[[0]],[[1]]],
                   [[[-1]],[[0]],[[1]]],
                   [[[-1]],[[0]],[[1]]]])
print('적용할 filter shape : {}'.format(weight.shape))

# stride : 1 (가로1, 세로1)
# padding = 'VALID'

conv2d = tf.nn.conv2d(channel_1_input_image,
                      weight,
                      strides=[1,1,1,1],
                      padding='VALID').numpy()


t_img = conv2d[0,:,:,:]
# 두번째 그림판에 convolution한 이미지(특징을 뽑아낸) 출력
ax2.imshow(t_img)

## pooling 처리 ##

# ksize = pooling filter의 크기 / # kernel의 크기가 3x3임.
pool = tf.nn.max_pool(conv2d, 
                      ksize=[1,3,3,1],
                      strides=[1,3,3,1], 
                      padding='VALID').numpy()

t_img = pool[0,:,:,:]
# 세번째 그림판에 pooling한 이미지(크기를 줄인) 출력
ax3.imshow(t_img)

fig.tight_layout()
plt.show()
```
![](2023-04-05-17-40-44.png)

##### (3) MNINST 기법별 비교 구현(3가지)
```python
# 공통코드 (사용할 모듈 적용)
import numpy as np
import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import MinMaxScaler
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Flatten, Dense
from tensorflow.keras.optimizers import Adam
from tensorflow.keras.callbacks import EarlyStopping

# Raw Data Loading
df = pd.read_csv('/content/drive/MyDrive/[파이썬 실습]/train.csv')
# display(df.head(), df.shape)
# 샘플 데이터라서 결측치와 이상치가 없음. 따라서, 해당 전처리는 수행하지 않음.

# 데이터를 나눌꺼에요 (train(7), test(3))
x_data_train, x_data_test, t_data_train, t_data_test = \
train_test_split(df.drop('label', axis=1, inplace=False),
                 df['label'],
                 test_size=0.3)

# 정규화 작업 수행
scaler = MinMaxScaler()
scaler.fit(x_data_train)
x_data_train_norm = scaler.transform(x_data_train)
x_data_test_norm = scaler.transform(x_data_test)
```

##### (3-1) MNIST를 Multinomial classification으로 구현해 정확도를 판단
```python
from keras.engine.training import optimizer
# 첫번째 Model => Multinomial Classification(머신러닝)
model_1 = Sequential()

model_1.add(Flatten(input_shape=(784,)))
model_1.add(Dense(10, activation='softmax'))

model_1.compile(optimizer=Adam(learning_rate=1e-4),
                loss='sparse_categorical_crossentropy',
                metrics=['accuracy'])

early_stopping = EarlyStopping(monitor='val_loss',
                               patience=3,
                               verbose=1,
                               mode='auto',
                               restore_best_weights=True)
# 모델 학습
model_1.fit(x_data_train_norm,
            t_data_train,
            epochs=2000,
            validation_split=0.2,
            verbose=1,
            batch_size=100,
            callbacks=[early_stopping])
```
![](2023-04-05-17-44-36.png)

```python
# 첫번째 Model => Multinomial Classification(머신러닝)
# 평가는? 0.9229364991188049
print(model_1.evaluate(x_data_test_norm, t_data_test))
```
![](2023-04-05-17-45-20.png)
##### (3-2) NIST를 DNN으로 구현해 정확도를 판단
```python
# 두번째 Model => DNN (딥러닝)
model_2 = Sequential()

model_2.add(Flatten(input_shape=(784,)))
# hidden layer가 포함됨(3개 주입)
model_2.add(Dense(64, activation='relu'))
model_2.add(Dense(128, activation='relu'))
model_2.add(Dense(32, activation='relu'))

model_2.add(Dense(10, activation='softmax'))

model_2.compile(optimizer=Adam(learning_rate=1e-4),
                loss='sparse_categorical_crossentropy',
                metrics=['accuracy'])

early_stopping = EarlyStopping(monitor='val_loss',
                               patience=3,
                               verbose=1,
                               mode='auto',
                               restore_best_weights=True)

# 모델 학습
model_2.fit(x_data_train_norm,
            t_data_train,
            epochs=2000,
            validation_split=0.2,
            verbose=1,
            batch_size=100,
            callbacks=[early_stopping])
```
![](2023-04-05-17-45-58.png)
```python
# 두번째 Model => DNN(딥러닝)
# 평가는?  첫번째 : 0.9229364991188049
#          두번째 : 0.9603968262672424
print(model_2.evaluate(x_data_test_norm, t_data_test))
```
![](2023-04-05-17-46-19.png)

##### (3-3) MNIST를 CNN으로 구현해 정확도를 판단(Vision의 시작점)
```python
# 세번째 Model => CNN (딥러닝)
from tensorflow.keras.layers import Conv2D, MaxPooling2D, Dropout

model_3 = Sequential()

# BOX 생성 Feature Extraction(convolution 처리)

# input layer를 별도로 잡지 않고, convolution layer에 같이 처리함
# convoution에 들어오는 데이터는 4차원 데이터임.
model_3.add(Conv2D(filters=32,
                   kernel_size=(3,3),
                   activation='relu',
                   input_shape=(28,28,1))) #relu 값을 변경해서 다음 unit으로 보내는 함수 처리

# Pooling
model_3.add(MaxPooling2D(pool_size=(2,2)))

# conv
model_3.add(Conv2D(filters=64,
                   kernel_size=(3,3),
                   activation='relu')) 

# Pooling
model_3.add(MaxPooling2D(pool_size=(2,2)))

# conv
model_3.add(Conv2D(filters=64,
                   kernel_size=(3,3),
                   activation='relu')) 

model_3.add(Flatten())
# hidden layer가 포함됨(1개 주입)
model_3.add(Dense(128, activation='relu'))
model_3.add(Dense(10, activation='softmax'))

model_3.compile(optimizer=Adam(learning_rate=1e-4),
                loss='sparse_categorical_crossentropy',
                metrics=['accuracy'])

early_stopping = EarlyStopping(monitor='val_loss',
                               patience=3,
                               verbose=1,
                               mode='auto',
                               restore_best_weights=True)

# 모델 학습
model_3.fit(x_data_train_norm.reshape(-1,28,28,1),
            t_data_train,
            epochs=2000,
            validation_split=0.2,
            verbose=1,
            batch_size=100,
            callbacks=[early_stopping])
```
![](2023-04-05-17-46-46.png)
```python
# 세번째 Model => CNN(딥러닝)
# 평가는?  첫번째 : 0.9229364991188049
#          두번째 : 0.9603968262672424
#          세번째 : 0.9821428656578064
print(model_3.evaluate(x_data_test_norm.reshape(-1,28,28,1), t_data_test))
```
![](2023-04-05-17-47-04.png)