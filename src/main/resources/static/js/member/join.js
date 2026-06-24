const joinFn = async () => {

    const form = document.getElementById('joinForm');

    const formData = new FormData(form);

    try {

        const response = await fetch(
            '/api/member/join',
            {
                method: 'POST',
                body: formData
            }
        );

        const data = await response.json();

        console.log(data);

        alert('회원가입 완료');

        // 회원목록으로 이동
        location.href = "/memberList.html";

    } catch (error) {

        console.error(error);

        alert('회원가입 실패');
    }
};