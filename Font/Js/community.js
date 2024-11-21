function filterPosts() {
    const stressFilter = document.getElementById('stressFilter').value;
    const categoryFilter = document.getElementById('categoryFilter').value;

    const posts = document.querySelectorAll('.post-card');

    posts.forEach(post => {
        const postStress = post.getAttribute('data-stress');
        const postCategory = post.getAttribute('data-category');

        // Check if the post matches the selected filters
        const stressMatch = stressFilter === 'all' || postStress === stressFilter;
        const categoryMatch = categoryFilter === 'all' || postCategory === categoryFilter;

        // Show or hide the post based on filter match
        if (stressMatch && categoryMatch) {
            post.style.display = 'block';
        } else {
            post.style.display = 'none';
        }
    });
}


// document.querySelectorAll('.post-card').forEach(postCard => {
//     postCard.addEventListener('click', () => {
//         const title = postCard.querySelector('.post-title').innerText;
//         const content = postCard.querySelector('.post-content').innerText;
//         const stressLevel = postCard.getAttribute('data-stress');
//         const category = postCard.getAttribute('data-category');

//         localStorage.setItem('postTitle', title);
//         localStorage.setItem('postContent', content);
//         localStorage.setItem('postStress', stressLevel);
//         localStorage.setItem('postCategory', category);

//         window.location.href = 'post.html';
//     });
// });


// ดึงข้อมูลจาก API
fetch('http://localhost:8080/api/posts')
    .then(response => response.json())
    .then(data => {
        const postsContainer = document.querySelector('.posts-container');
        postsContainer.innerHTML = ''; // ล้างข้อมูลเดิมใน container

        data.forEach(post => {
            // สร้างโครงสร้าง HTML สำหรับแต่ละโพสต์
            const postCard = document.createElement('div');
            postCard.classList.add('post-card');
            postCard.setAttribute('data-stress', post.stressLevel || 'unknown');
            postCard.setAttribute('data-category', post.category || 'unknown');

            postCard.innerHTML = `
              <span class="post-type">${post.category}</span>
                 <div class="post-title">${post.title}</div>
                <div class="post-content" style="display: none;"></div>
          
            `;

            // // เพิ่ม event listener เพื่อให้คลิกเปิด/ปิดเนื้อหาเพิ่มเติม
            // postCard.querySelector('.post-title').addEventListener('click', () => {
            //     const content = postCard.querySelector('.post-content');
            //     content.style.display = content.style.display === 'block' ? 'none' : 'block';
            //     window.location.href = 'post.html';
            // });
          console.log(post.id)
            postCard.addEventListener('click', (event) => {
                if (event.target === postCard) { // เช็คว่าคลิกบน postCard โดยตรง
                    const content = postCard.querySelector('.post-content');
                    content.style.display = content.style.display === 'block' ? 'none' : 'block';
                    window.location.href = `post.html?id=${post.id}&category=${post.category}&title=${post.title}&body=${post.body}`

                }
            });
            
            postsContainer.appendChild(postCard);
        });
    })
    .catch(error => {
        console.error('Error fetching posts:', error);
    });
          
