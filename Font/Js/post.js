const params = new URLSearchParams(window.location.search);
const postId = params.get('id');
const title = params.get('title');
const body = params.get('body');
const category = params.get('category');

document.addEventListener('DOMContentLoaded', () => {
   

//     // Map categories to Thai labels
//     const categoryMap = {
//         'recommend': 'แนะนำ',
//         'question': 'สอบถามปัญหา',
//         'other': 'อื่นๆ'
//     };
//     const thaiCategory = categoryMap[category] || 'ไม่ระบุ';

    // Display title, content, and category in Thai
    document.getElementById('postTitleContent').textContent = title || 'ไม่มีข้อมูล';
    document.getElementById('postFullContent').textContent = body || 'ไม่มีข้อมูล';
    document.getElementById('postCategory').textContent = category;

    // Display stress level with colored circle
    const stressIndicator = document.getElementById('postStressIndicator');
    stressIndicator.classList.add(`stress-${stressLevel}`);
    stressIndicator.innerHTML = `<span class="status-dot ${stressLevel}">`;
});


console.log(postId);
const api = 'http://localhost:8080/api/comment/all/'+postId;
console.log(api);



// function loadComments() {
//     const commentsList = document.getElementById("commentsList");
//     commentsList.innerHTML = ""; // Clear current comments

//     data.forEach((comment) => {
//         const commentItem = document.createElement("div");
//         commentItem.className = "comment-item";
//         commentItem.textContent = comment.text;
//         commentsList.appendChild(commentItem);
//     });
// }
fetch(api)  // เปลี่ยนเป็น URL ของ API
.then(response =>  response.json())
.then(apiData => {
    console.log('ข้อมูลจาก API:', apiData);

    
    loadComments(comments);
})
.catch(error => {
    console.error('Error fetching comments:', error);
    comments = []; // ในกรณีที่เกิดข้อผิดพลาด ให้ใช้ comments เป็นอาร์เรย์เปล่า
    loadComments(comments);
});


function loadComments() {
    const commentsList = document.getElementById("commentsList");
    commentsList.innerHTML = ""; // ล้างความคิดเห็นเก่า
 // ตรวจสอบว่า commentsArray เป็นอาร์เรย์ก่อนที่จะใช้ forEach 
            data.forEach(comment => {
            const commentItem = document.createElement("div");
            commentItem.className = "comment-item";
            commentItem.textContent = comment.body || comment.text; // ใช้ฟิลด์ 'body' หรือ 'text' แสดงข้อความ
            commentsList.appendChild(commentItem);
        });
}
// เรียกฟังก์ชันดึงข้อมูลความคิดเห็น
// Function to add a new comment
function addComment() {
    const commentInput = document.getElementById("commentInput");
    const commentText = commentInput.value.trim();
    if (commentText) {
        const payload = {
            body: commentText,
           post: {   
               id: postId // ตัวอย่าง id ของผู้ใช้
           }
       };
        comments.push({ text: commentText });
        loadComments();
        commentInput.value = ""; // Clear the input field

    
        fetch('http://localhost:8080/api/comment', {
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
            document.getElementById('commentInput').value = ''; 
        })
            .catch((error) => {
                alert(`เกิดข้อผิดพลาด: ${error.message}`);
            });
    }else {
        alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    }
}

// Load comments when the page loads
window.onload = loadComments;
