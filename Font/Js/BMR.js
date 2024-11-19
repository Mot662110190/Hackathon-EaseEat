let selectedGender = '';
let selectedActivityMultiplier = 0;
let bmr = 0;

function selectGender(gender) {
    selectedGender = gender;
    document.querySelectorAll('.gender-button').forEach(button => {
        if (button.textContent === gender) {
            button.style.backgroundColor = '#AAB396';
            button.style.color = '#fff';
        } else {
            button.style.backgroundColor = '#fff';
            button.style.color = '#000';
        }
    });
}

function calculateBMR() {
    const weight = parseFloat(document.getElementById('weight').value);
    const height = parseFloat(document.getElementById('height').value);
    const age = parseInt(document.getElementById('age').value, 10);

    if (!selectedGender || isNaN(weight) || isNaN(height) || isNaN(age)) {
        alert('กรุณากรอกข้อมูลให้ครบถ้วน');
        return;
    }

    if (selectedGender === 'ชาย') {
        bmr = 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
    } else if (selectedGender === 'หญิง') {
        bmr = 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
    }
}

function selectActivity(multiplier) {
    selectedActivityMultiplier = multiplier;
    document.querySelectorAll('.Tdee-button').forEach(button => {
        button.style.backgroundColor = '#fff';
        button.style.color = '#000';
    });
    event.target.style.backgroundColor = '#AAB396';
    event.target.style.color = '#fff';
}

function calculateTDEE() {
    calculateBMR(); // คำนวณค่า BMR ก่อน
    if (bmr === 0) {
        alert('กรุณากรอกข้อมูลให้ครบถ้วนและคำนวณ BMR ก่อน');
        return;
    }

    if (selectedActivityMultiplier === 0) {
        alert('กรุณาเลือกระดับกิจกรรม');
        return;
    }

    const tdee = bmr * selectedActivityMultiplier;
   
    const calorieForMaintenance = tdee.toFixed(2);
    const calorieForWeightGain = (tdee * 1.2).toFixed(2);

    
    localStorage.setItem('bmr', bmr.toFixed(2));
    localStorage.setItem('tdee', tdee.toFixed(2));

    localStorage.setItem('calorieForMaintenance', calorieForMaintenance);
    localStorage.setItem('calorieForWeightGain', calorieForWeightGain);

    window.location.href = 'resultBMR.html'; 
}