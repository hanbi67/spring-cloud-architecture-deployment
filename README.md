# CH 4 클라우드_아키텍처 설계 & 배포

---
### 수행한 단계

`필수 기능` LV 0 - 요금 폭탄 방지 AWS Budget 설정

`필수 기능` LV 1 - 네트워크 구축 및 핵심 기능 배포

`필수 기능` LV 2 - DB 분리 및 보안 연결하기

`필수 기능` LV 3 - 프로필 사진 기능 추가와 권한 관리

`도전 기능` Lv 4, 5, 6 미구현

---
### LV 0 - 요금 폭탄 방지 AWS Budget 설정
![img_1.png](images/img_1.png)

### LV 1 - 네트워크 구축 및 핵심 기능 배포

- EC2의 퍼블릭 IP: `3.34.135.206`

### LV 2 - DB 분리 및 보안 연결하기 

1. Actuator Info 엔드포인트 URL: http://3.34.135.206:8080/actuator/info
2. RDS 보안 그룹 스크린샷
![img_2.png](images/img_2.png)

### LV 3 - 프로필 사진 기능 추가와 권한 관리

#### ▼ Presigned URL 
https://my-cloud-architecture-leehanbi-files.s3.ap-northeast-2.amazonaws.com/uploads/8491dd62-2064-4d0c-aa6e-985f70c290f4_aws_logo.png?X-Amz-Security-Token=IQoJb3JpZ2luX2VjECUaDmFwLW5vcnRoZWFzdC0yIkYwRAIgAfYyLamnco2qYzexg5kOwms%2BKQzkzwLuU0zafCmMd%2FYCIEykx3KLgKeAylv8GxMoXmhbLQJ06oeuy2bNxdUOzs7%2FKtIFCO%2F%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FwEQABoMMTcwNjM4MTk5NzE2Igzg9JHOYzy2VcTejkgqpgW0NHOcrgdQsNSArvFoZEy%2BlSZuulH8Hbj5FiWntcrkB%2BlyoHH8YvUNrUwDYXJW9rvgzw6GFIzxaE1NLxc53%2FKmzQvhFa27AB%2BWL2wIiVEbb75X4zG9YO0i3mHtmo5PBP4bxI7YLb53Qc%2BMfmSBme%2BGxRvGRBkjHj8EeBRpAim7pJa45MVVBp%2Fp6R0kfskCAoIdO4WGm07%2FQy4uQg6%2Fa%2B8V8eU2b1N8%2B2EJKk7EPBpeJHmy8JhvXv%2FLZTzBIZcGRDjfAiyVRBtZzqhEO5q53czRvMzIFqHJldeIky5V1Pel3leuCW8lNqrRcTZ6s6DQQQaH6lFMm2FepoaXgv8ROiNUYdMT210INtOvYUP2fSONpcwQ%2BrMXHD42dzDxkbb5QamZBr5eqtHCXGFx%2BGaUoM%2FPAOqK%2FpjBjqZWurwrM3imAkCHhJPURpRk97Kt5XaZ%2BVD8PBZj%2FKoqj9mBPxP4%2Fz5FQ4S3D9wvJYSZSO76fsTL%2Bc01g9M3J7Gve%2FnAeVMqnZC9s3YVgNYbn%2FPk6E%2Br0wyuj0NS%2BpEEgTCXFrjr0Mb9nOzANwDnZOJv5UwapmEkWZyhaQqr2qcsnta%2BNT7P8HpJTvOyC%2FpFUPFwuwyYqIScHcgZMIgAB7MPwlquGfAhFjMrXsfK0TnfU%2BhYZNPuWKHbfb%2F0ZDfhxgvQALR35DjuJTf1xPAKD9Q8i9RThU%2BZZMLb8fepMHY4123eIi4r9EVyo1Bun%2BSet6HJMumL0X1%2FQnzJH8fVupCoNBbjbjDU%2F%2FLM8wYqWYbPRr5tOoU%2B0tzWbnH2rLAtSZe1c4Gcz4JJTxtLUe5LL4Nw3P%2BJnz%2BdAz0xitjL2hP3KiQZMhn8xkRuTqwWSgw9HYdVvNGz8VWri9kc48lQvZ6Xw%2FdHwLpMpMyg2A2pu10whq2EzAY6sgEvJZ%2FbL%2BU8dRoC5v0HHkITvOguos8GuUX4N7crdWzsmPIVTqBsq7sCoh7gzT0DCwbG2XM06aaPp2DHoLt51kW%2FuxgtJCKhXlB9HL62tYmdVrr5vezT9CVx3WDoCIBuAVKZufFjAp4EkaScyF3KuenXpr0Rz%2FbUeKz8v7qrQ%2Ft8VVp2LoySI3%2BuEr1ppn5fwua3JrbERQUKXlpvcxuVRXDLGtfiv%2B1OOzk%2Fd7Zkhf6CjtUF&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20260202T222135Z&X-Amz-SignedHeaders=host&X-Amz-Credential=ASIASPOWUJOSNGD23BAJ%2F20260202%2Fap-northeast-2%2Fs3%2Faws4_request&X-Amz-Expires=604800&X-Amz-Signature=b3602bb4de6615e67d750e142d24eea17c3f33029aaed0cfd9ec1df788245b90

<br/>

#### ▼ 만료 시간
- 생성 일시: 2026년 2월 3일 07:21:35 (KST)
- 만료 일시: 2026년 2월 10일 07:21:35 (KST)
- 유효 기간: 7일 (604800초)

<br/>
<br/>

---

### 트러블슈팅

https://velog.io/@dlql6717/TIL-CH-4-클라우드아키텍처-설계-배포-과제-트러블슈팅-정리

<br/><br/>