
function validate(){
    let valid = true;
    let nameProduct = document.getElementById('nameProduct');
    let description = document.getElementById('description');
    let price = document.getElementById('price');
    let isbn = document.getElementById('isbn');
    let count = document.getElementById('count');
    
    if(nameProduct.value < 1){
        nameProduct.className = 'invalid';
        valid = false;
    }else{
        nameProduct.className = '';
        valid = true;
    }
    
    if(description.value < 1){
        description.className = 'invalid';
        valid = false;
    }else{
        description.className = '';
        valid = true;
    }
    
    if(price.value < 1){
        price.className = 'invalid';
        valid = false;
    }else{
        price.className = '';
        valid = true;
    }
    if(isbn.value < 1){
        isbn.className = 'invalid';
        valid = false;
    }else{
        isbn.className = '';
        valid = true;
    }
    if(count.value < 1){
        count.className = 'invalid';
        valid = false;
    }else{
        count.className = '';
        valid = true;
    }
    return valid;
}
