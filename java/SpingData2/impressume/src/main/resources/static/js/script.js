$(document).ready(function() {
  $('#slides').superslides({
    animation: 'fade',
    play: 3500,
    pagination: false,
  });

  var typed = new Typed(".typed", {
    strings: ["Software Enigneer.", "Full Stack Developer.", "Gamer."],
    typeSpeed: 70,
    loop: true,
    startDelay: 1000,
    showCursor: false
  });

  $('.owl-carousel').owlCarousel({
    loop:true,
    items: 4,
    nav:true,
    responsive:{
        0:{
            items:1
        },
        480:{
            items:2
        },
        768:{
            items:3
        },
        938:{
          items:4
      }
    }
  });

  var skillsTopOffset = $(".skillSection").offset().top;
  
  $(window).scroll(function() {
    if (window.pageYOffset > skillsTopOffset - $(window).height() + 200) {
      $('.chart').easyPieChart({
        easing: 'easeInOut',
        barColor:"#fff",
        trackColor: false,
        scaleColor: false,
        lineWidth: 4,
        size: 152,
        onStep: function(from, to, percent) {
          $(this.el).find('.percent').text(Math.round(percent))
        },
        animate: {
          duration: 3000,
          enabled: true
        }
      });
    }
  });

  $("[data-fancybox]").fancybox();

  $(".items").isotope({
    filter: "*",
    animationOptions: {
      duration: 1500,
      easing: 'linear',
      queue: false
    }
  })
  var modal = document.getElementById("gameModal")
  $("#gameBtn").click(function() {
    $("#gameModal").css('display', 'block');
  })
  
  window.onclick = function(event) {
    if (event.target == modal) {
      $("#gameModal").css('display', 'none');
    }
  }

});