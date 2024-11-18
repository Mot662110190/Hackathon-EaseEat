<?php
// เชื่อมต่อกับฐานข้อมูล
$conn = new mysqli('localhost', 'root', '', 'your_database_name');

// ตรวจสอบการเชื่อมต่อ
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// รับข้อมูลจากฟอร์ม
$username = $_POST['username'];
$name = $_POST['name'];
$password = $_POST['password'];
$confirm_password = $_POST['confirm_password'];

// ตรวจสอบว่า Password และ Confirm Password ตรงกัน
if ($password !== $confirm_password) {
    echo "<script>
        alert('Password และ Confirm Password ไม่ตรงกัน!');
        window.history.back();
    </script>";
    exit();
}

// เข้ารหัส Password
$hashed_password = password_hash($password, PASSWORD_DEFAULT);

// บันทึกข้อมูลลงฐานข้อมูล
$sql = "INSERT INTO users (username, name, password) VALUES ('$username', '$name', '$hashed_password')";

if ($conn->query($sql) === TRUE) {
    echo "<script>
        alert('ลงทะเบียนสำเร็จ!');
        window.location.href = 'login.html';
    </script>";
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}

// ปิดการเชื่อมต่อฐานข้อมูล
$conn->close();
?>
