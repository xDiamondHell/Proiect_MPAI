$(document).ready(function() {

  updatePrice();
  $('.color-choose input').on('click', function() {
      var headphonesColor = $(this).attr('data-image');

      $('.active').removeClass('active');
      $('.left-column img[data-image = ' + headphonesColor + ']').addClass('active');
      $(this).addClass('active');
      updatePrice();
  });
  
  $('.button-wrap input').on('click', function() {
      updatePrice();
  });

});

function updatePrice() {
    var wineColorPrice = 0;
      var wineTypePrice = 0;

      if($('#red').prop('checked')) {
      wineColorPrice = 100;
	  }
	  else if($('#rose').prop('checked')) {
      wineColorPrice = 200;
	  } else if($('#white').prop('checked')) {
      wineColorPrice = 300;
	  }
	  
	  if($('#sec').prop('checked')) {
      wineTypePrice = 10;
	  }
	  else if($('#demisec').prop('checked')) {
      wineTypePrice = 20;
	  } else if($('#demidulce').prop('checked')) {
      wineTypePrice = 30;
	  } else if($('#dulce').prop('checked')) {
      wineTypePrice = 40;
	  }
	  
	  $('.product-price span').text('$'+ (wineTypePrice + wineColorPrice) );
	  sessionStorage.setItem('sumaDePlata', (wineTypePrice + wineColorPrice));
	  document.cookie = 'sumaDePlata=' + (wineTypePrice + wineColorPrice);
}
