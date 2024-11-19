let currentQuestionIndex = 0;
const questions = document.querySelectorAll('.question-group');
const submitButton = document.getElementById('submitButton');
const nextButton = document.getElementById('nextButton');
let answers = {}; // เก็บคำตอบของแต่ละคำถาม

// ฟังก์ชันในการเลือกคำตอบ
function selectAnswer(questionIndex, value, button) {
    answers[questionIndex] = value;

    // นำคลาส selected ออกจากปุ่มทั้งหมดในคำถามนี้
    const buttons = questions[questionIndex].querySelectorAll('button');
    buttons.forEach(button => button.classList.remove('selected'));

    // เพิ่มคลาส selected ให้กับปุ่มที่ถูกเลือก
    button.classList.add('selected');
    console.log(`เลือกคำตอบของคำถามที่ ${questionIndex + 1}: ${value}`);
}

// ฟังก์ชันในการแสดงคำถาม
function showQuestion(index) {
    questions.forEach((q, i) => q.style.display = i === index ? 'block' : 'none');

    // แสดงปุ่ม "ส่งแบบประเมิน" เมื่อถึงคำถามสุดท้าย
    if (currentQuestionIndex === questions.length - 1) {
        nextButton.style.display = 'none'; // ซ่อนปุ่มถัดไป
        submitButton.style.display = 'block'; // แสดงปุ่มส่งแบบประเมิน
    } else {
        nextButton.style.display = 'block'; // แสดงปุ่มถัดไป
        submitButton.style.display = 'none'; // ซ่อนปุ่มส่งแบบประเมิน
    }
}

// ฟังก์ชันในการไปยังคำถามถัดไป
function nextQuestion() {
    if (answers[currentQuestionIndex] === undefined) {
        alert("กรุณาตอบคำถามก่อนดำเนินการต่อ");
        return;
    }

    if (currentQuestionIndex < questions.length - 1) {
        currentQuestionIndex++;
        showQuestion(currentQuestionIndex);
    }
}

// ฟังก์ชันในการคำนวณผลลัพธ์
function calculateDASS() {
    let totalScore = Object.values(answers).reduce((sum, value) => sum + parseInt(value), 0);
    let resultText = "";
    let resuInfor = "";

    // แสดงผลการประเมินตามคะแนนที่คำนวณ
    const stressCircle = document.getElementById('stressCircle');
    if (totalScore <= 21) {
        resultText = "ผลการประเมิน: ความเครียดต่ำ";
        resuInfor = "ระดับความเครียดต่ำอาจไม่ส่งผลกระทบมากนักต่อสุขภาพจิตและการกิน แต่อย่างไรก็ตาม ควรดูแลความเครียดอย่างต่อเนื่องโดยการทำกิจกรรมที่ชื่นชอบ เช่น การออกกำลังกายเบา ๆ การทำสมาธิ หรือการเดินเล่น เพื่อรักษาความสมดุลทางอารมณ์และลดความเสี่ยงต่อการสะสมความเครียดในอนาคต";
        stressCircle.className = 'circle green';
    } else if (totalScore <= 42) {
        resultText = "ผลการประเมิน: ความเครียดปานกลาง";
        resuInfor = "ระดับความเครียดปานกลางสามารถส่งผลกระทบต่ออารมณ์และการจัดการการกิน ควรเริ่มหาวิธีคลายเครียด เช่น การฝึกโยคะ การเขียนบันทึกเพื่อสะท้อนความรู้สึก หรือการปรึกษาผู้เชี่ยวชาญเพื่อพูดคุยถึงความเครียด ควรระวังไม่ให้ความเครียดนำไปสู่การควบคุมการกินที่มากเกินไป และพยายามดูแลโภชนาการให้ครบถ้วนในแต่ละวัน";
        stressCircle.className = 'circle yellow';
    } else if (totalScore <= 63) {
        resultText = "ผลการประเมิน: ความเครียดสูง";
        resuInfor = "ความเครียดสูงอาจเริ่มส่งผลกระทบอย่างมีนัยสำคัญต่อสุขภาพจิต ควรพิจารณาการเข้ารับการบำบัดจากผู้เชี่ยวชาญด้านสุขภาพจิต เช่น การบำบัดความคิดและพฤติกรรม (CBT) เพื่อปรับทัศนคติและความเชื่อที่มีต่อน้ำหนักและการกิน รวมถึงการรับคำปรึกษาจากนักโภชนาการในการปรับแผนอาหารเพื่อสุขภาพ นอกจากนี้ ควรฝึกฝนทักษะการผ่อนคลายและจัดการกับความเครียดในชีวิตประจำวันอย่างจริงจัง";
        stressCircle.className = 'circle orange';
    } else {
        resultText = "ผลการประเมิน: ความเครียดสูงมาก";
        resuInfor = "ความเครียดในระดับสูงมากอาจเป็นอันตรายต่อสุขภาพกายและจิตใจ อาจจำเป็นต้องเข้ารับการดูแลอย่างเข้มข้นจากทีมแพทย์ในโรงพยาบาลหรือคลินิกเฉพาะทาง ซึ่งอาจรวมถึงการบำบัดโดยแพทย์ นักจิตวิทยา และนักโภชนาการ เพื่อช่วยให้ผู้ป่วยรับรู้ถึงคุณค่าของการดูแลตนเอง การฟื้นฟูสุขภาพกายและใจ ควบคู่ไปกับการสร้างกลไกในการจัดการกับความเครียด";
        stressCircle.className = 'circle red';
    }

    localStorage.setItem('totalScore', totalScore);
    localStorage.setItem('resuInfor', resuInfor);
    localStorage.setItem('resultText', resultText);
    
    window.location.href = 'Formresult.html';
}

// เริ่มต้นโดยแสดงคำถามแรก
showQuestion(currentQuestionIndex);


