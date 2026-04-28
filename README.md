Phát triển Ứng dụng Mobile Xem Phim Trực Tuyến
Dự án này là kết quả của bài tập lớn môn Lập trình Mobile cơ bản, tập trung vào việc xây dựng một ứng dụng giải trí hiện đại, tối ưu hóa trải nghiệm người dùng trên nền tảng di động
.
1. Tổng quan đề tài
Trong bối cảnh công nghệ số, nhu cầu xem phim trực tuyến trên smartphone ngày càng tăng cao
. Ứng dụng này được phát triển nhằm cung cấp một nền tảng xem phim chất lượng cao, hỗ trợ tìm kiếm thông minh và cá nhân hóa trải nghiệm
.
Sinh viên thực hiện: Hoàng Minh Hiếu
.
Giảng viên hướng dẫn: Ths. Bùi Đức Thọ
.
Đơn vị: Khoa Công nghệ thông tin – Trường Đại học Sư phạm Kỹ thuật Hưng Yên
.
2. Công nghệ sử dụng
Nền tảng: Hệ điều hành Android
.
Công cụ phát triển: Android Studio
.
Cơ sở dữ liệu & Backend (Firebase):
Realtime Database: Lưu trữ và đồng bộ dữ liệu thời gian thực
.
Cloud Firestore: Quản lý dữ liệu theo mô hình trực quan, khả năng mở rộng cao
.
Cloud Storage: Không gian lưu trữ tệp tin (ảnh, video) không giới hạn
.
Authentication: Xác thực người dùng qua Email, Facebook, Google...
.
Giao diện: Sử dụng các thành phần như RecyclerView, EditText, Animation, Drawable để tối ưu trải nghiệm
.
3. Các chức năng chính
Đối với Người dùng
Đăng ký & Đăng nhập: Tạo tài khoản và xác thực danh tính
.
Xem phim: Hỗ trợ xem cả phim lẻ (phim ngắn) và phim bộ theo từng tập
.
Tìm kiếm & Lọc: Tìm phim theo tên, từ khóa hoặc lọc theo thể loại (hành động, tình cảm, kinh dị...)
.
Cá nhân hóa: Cập nhật thông tin cá nhân, đổi mật khẩu và quản lý danh sách phim yêu thích
.
Đối với Quản trị viên (Admin)
Quản lý phim: Thêm, sửa, xóa thông tin phim lẻ và phim bộ (tên, thời lượng, mô tả, video, poster...)
.
Quản lý người dùng: Thêm, xóa, tìm kiếm và cập nhật trạng thái tài khoản
.
Thống kê báo cáo:
Thống kê phim xem nhiều nhất
.
Thống kê tài khoản hoạt động tích cực
.
Theo dõi số lượng người đăng ký mới và ghi nhận lỗi hệ thống
.
4. Cấu trúc cơ sở dữ liệu
Hệ thống được thiết kế với các bảng dữ liệu chính:
users: Lưu trữ thông tin tài khoản, email, mật khẩu (đã mã hóa) và vai trò
.
Movie: Thông tin chi tiết về phim lẻ (thời lượng, quốc gia, link phim...)
.
Series & Episode: Quản lý phim bộ và danh sách các tập phim tương ứng
.
Director & Actor: Thông tin về đạo diễn và diễn viên
.
Review: Lưu trữ các đánh giá và điểm số từ người dùng
.
5. Quy trình triển khai và Đóng gói
Quy trình phát triển: Áp dụng mô hình Thác nước (Waterfall) và Xoắn ốc (Spiral) để quản lý rủi ro và chất lượng
.
Kiểm thử: Đã thực hiện kiểm thử các case đăng nhập, đăng ký và tìm kiếm để đảm bảo tính ổn định
.
Đóng gói: Ứng dụng được đóng gói dưới dạng file APK hoặc Android App Bundle thông qua Android Studio
.
6. Hướng phát triển tương lai
Tối ưu hóa cấu trúc mã nguồn để dễ dàng kiểm thử và bảo trì
.
Nghiên cứu thêm các kiến trúc hệ thống hiện đại để mở rộng ứng dụng
.
Cập nhật thêm các tính năng nghiệp vụ còn thiếu và sửa lỗi tồn đọng
.

--------------------------------------------------------------------------------
Dự án được thực hiện trong giai đoạn từ 20/12/2025 đến 15/03/2026
