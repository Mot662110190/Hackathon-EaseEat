let selectedCategory = '';
let selectedAnonymity = '';

// Function to select category and go to anonymity selection
function selectCategory(category) {
    selectedCategory = category;
    document.getElementById('categoryStep').style.display = 'none'; // Hide category selection
    document.getElementById('anonymityStep').style.display = 'block'; // Show anonymity selection
}

// Function to select anonymity and go to content step
function selectAnonymity(anonymity) {
    selectedAnonymity = anonymity;
    document.getElementById('anonymityStep').style.display = 'none'; // Hide anonymity selection
    document.getElementById('contentStep').style.display = 'block'; // Show content input
}

// Function to handle post submission
document.querySelector('.submit-button').addEventListener('click', function () {
    const title = document.getElementById('post-title').value.trim();
    const content = document.getElementById('post-content').value.trim();
    // const id = document.getElementById('').value.trim();//เพิ่มไอดี
    if (title && content) {
        // สร้าง payload สำหรับส่งไปยัง Backend
        const payload = {
            category: selectedCategory,
            anonymity: selectedAnonymity,
            title: title,
            body: content,
            user: {   
                id: 1 // ตัวอย่าง id ของผู้ใช้
            }
        };

        // ใช้ Fetch API สำหรับเรียก API Backend
        fetch('http://localhost:8080/api/posts', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(payload),
        })
            .then((response) => {
                if (!response.ok) {
                    throw new Error('การส่งโพสต์ล้มเหลว');
                }
                return response.json();
            })
            .then((data) => {
                alert(`โพสต์สำเร็จ! หมายเลขโพสต์ของคุณคือ: ${data.postId}`);
                // ทำความสะอาดฟอร์มหรือรีเซ็ตหน้าจอ
                document.getElementById('post-title').value = '';
                document.getElementById('post-content').value = '';
                document.getElementById('contentStep').style.display = 'none';
                document.getElementById('categoryStep').style.display = 'block';
                // document.getElementById('categoryStep').style.display = 'block';//เพิ่มไอดี
            })
            .catch((error) => {
                alert(`เกิดข้อผิดพลาด: ${error.message}`);
            });
    } else {
        alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    }
});
