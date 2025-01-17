# 👩🏻‍💻 구현 기능 목록
## ☑️ 게임 로직 정리


1. 프로그램 시작 안내 문구를 출력한다.
   (안내 문구 메시지 : `"점심 메뉴 추천을 시작합니다."`<br>


2. 플레이어에게 메뉴 추천을 받을 코치의 이름을 입력받는다.<br>
   (입력 요청 메시지 : `"코치의 이름을 입력해 주세요. (, 로 구분)"`<br>
   -**코치 이름에 대한 유효성 검사를 실행한다.**<br>
   (유효성 검사를 실패할 경우 `IllegalArgumentException`을 발생시킨 후, 예외 메시지를 출력하고 재입력 받는다. 예외 메시지는 `"[ERROR]"`로 시작해야 한다.)<br>
   a. 플레이어의 입력값은 필수이다.<br>
   b. 코치의 이름은 최소 2글자, 최대 4글자이다.<br>
   c. 코치는 최소 2명, 최소 5명까지 입력 가능하다.<br>


3. 플레이어에게 각 코치가 먹지 못하는 음식을 입력받는다.<br>
   (입력 요청 메시지 : `"(코치명)(이)가 못 먹는 메뉴를 입력해 주세요."`<br>
   -**못 먹는 메뉴 입력값에 대한 유효성 검사를 실행한다.**<br>
   (유효성 검사를 실패할 경우 `IllegalArgumentException`을 발생시킨 후, 예외 메시지를 출력하고 재입력 받는다. 예외 메시지는 `"[ERROR]"`로 시작해야 한다.)<br>
   a. 각 코치는 최소 0개, 최대 2개의 못 먹는 메뉴가 있다. (먹지 못하는 메뉴가 없으면 빈 값을 입력한다.)<br>


4. 메뉴 추천 결과를 알리는 메세지를 출력한다.<br>
   (출력 메시지 : `"메뉴 추천 결과입니다."`<br>


5. **메뉴 추천 로직 정리** <br>
   -**코치들은 월, 화, 수, 목, 금요일에 점심 식사를 같이 한다.** <br>
   a. 월요일에 추천할 카테고리를 무작위로 정한다.<br>
   b. 각 코치가 월요일에 먹을 메뉴를 추천한다. (카테고리는 동일하다)<br>
   c. 화, 수, 목, 금요일에 대해 a-b의 과정을 반복한다.<br>
   -**카테고리 선정** <br>
   a. Randoms.pickNumberInRange()의 결과가 1이면 일식, 2면 한식, 3이면 중식, 4면 아시안, 5면 양식을 추천한다. <br>
   b. 한 주에 같은 카테고리를 최대 2회까지만 고를 수 있다.<br>
   c. 추천할 수 없는 카테고리인 경우, 카테고리를 다시 선정한다. <br>
   -**메뉴 선정** <br>
   a. Random.shuffle()을 통해 임의의 순서로 섞은 후, 첫 번째 값을 사용해야 한다. <br>
   b. 한 주에 중복되지 않은 메뉴를 추천해야 한다.<br>
   c. 추천할 수 없는 메뉴인 경우, 메뉴를 다시 선정한다. <br>


6. 메뉴 추천 결과를 실행 예시를 참고하여 출력한다.<br>
   `"[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]"`<br>
   `"[ 카테고리 | 한식 | 한식 | 일식 | 중식 | 아시안 ]"`<br>
   `"[ 코치1 | 메뉴1 | 메뉴2 | 메뉴3 | 메뉴4 | 메뉴5 ]"`


7. 프로그램 종료 안내 문구를 출력한다.<br>
   (안내 문구 메시지 : `"추천을 완료했습니다."`<br>