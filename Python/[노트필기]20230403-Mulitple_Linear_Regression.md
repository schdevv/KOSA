### 2023.04.03 

### 1. linear Regression(선형회귀) 
  1) 독립변수에 따른 수식 모델
    (1) 독립변수 1개 : y = Wx + b 
    ● y =예측값 / w = 가중치 / x = 독립변수 / b = 보정치
    (2) 독립변수 3개 : y = W1 X1 + W2 X2 + W3 X3 + b
    ● X1 = 온도 / X2 = 태양광 / X3 = 바람 / t = 오존량 
   - 교수님 정리자료 1장 참고하기 (결과5x1 => 5X3 x 3x1)

   2) Model을 통해 예측치를 도출하고 loss의 MSE를 이용해 실제값과 비교를 수행함

###  2. Multiple Linear Regression

```python

```

### 3. (Multple) Logistic Regression (종속변수의 data 형태가 바뀜)
  1) 예측치는 확률 값을 나타냄.
   (1) 교수님 참고 2번쨰 페이지 : key point: binary classification
    
  2) 왜 linear를 사용하지 못할까? 왜임?????????????????
  3) 수식 : sigmoid = 1 / 1 + e -2 
    - linear Regression model을 "-2" 부분에 대입함
    - model -> 1 / 1 + e -(x W + b)
  4) 처리방식 구분
● linear : Model ->예측치 도출 -> loss(식: MSE)로 실제값과 비교
● Logistic : Model -> 예측치 도출 ->loss(식: CrossEntroy)-> 비교 
  - 예측치 : 0 ~ 1사이의 값 / 예측치값이 0.3이면? 30% 확률임
 
 5) 평가(Evaluation) : linear보다 상대적으로 쉬운 편임.
  (1) 데이터관점의 평가방법 : 3가지로 구분(학습/학습확인/평가)
    ● 예시: Training Data Set을 7대3 혹은 8대2 비율로 데이터 분할
      - 일부분(7)을 학습시키고 남은 데이터(3)로 평가를 진행함
      - Training Data Set(7) : Test Data Set(3)
      - Training Data Set : 2가로 구분됨.
       -> 일부분은 학습만을 위한 Training Data Set
       -> 일부분은 학습 확인을 위한 validation Data Set 
      - Test Data Set : model의 정확도 최종 평가에 딱 1번 사용됨.

  (2) 평가 기준(Metric) 
교수님 수업자료 4페이지 참고.
    (1) Confusion Matrix(헷갈리는 Matrix) 
      ● 실제 정답(t)이 True : True
       - 예측값(y)의 예측값 True : True positive
       - 예측값(y)의 예측값 False : True Negative
      ● 실제 정답(t)이 Flase : False
       - 예측값(y)의 예측값 True : False positive
       - 예측값(y)의 예측값 False : False Negative

   (2) Accuracy Metric (정확도) 
      ●  TP + TN / TP + FN + FP + TN (*모든 경우)
        - 모든 case중, True값을 추려낸 비율로 정확도를 맞춤.
        - 데이터의 편향이 있는 데이터set에서는 사용하기 어려움
        - val_accuracy: 0.7013 (높을수록 정확함)
        - Hyper Parameter 수정 : epochs 숫자, learning_rate, 등
        - 데이터가 많을 수록 큰수의 법칙이 적용됨

    1. 연습문제 : Titanic (binary classification, 이항분류)
    1) kaggel : Machine Learning의 집합소 
    2) process(binary classification)
      (1) Data Set : 학습데이터로 변형
      (2) Model 학습
      (3) Model 완성
         ● test.csv로 model 사용
          - 입력 -> 출력 결과물을 File로 만들어 kaggle upload 채점
   