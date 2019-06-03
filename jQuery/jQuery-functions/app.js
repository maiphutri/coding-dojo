$("button.addClass").click(() => {
  $("p.addClass").addClass("red");
});

$("button.slideToggle").click(() => {
  $("img.slideToggle").slideToggle();
});

$("button.append").click(() => {
  $("p.append").append("\n<p><strong>New Paragraph!</strong></p>");
});

$("button.hide").click(() => {
  $("img.hide").hide();
});

$("button.show").click(() => {
  $("img.show").show();
});

$("button.toggle").click(() => {
  $("p.toggle strong").toggle();
});

$("button.slideDown").click(() => {
  $("p.slideDown").slideDown('slow');
});

$("button.slideUp").click(() => {
  $("p.slideUp").slideUp('slow');
});

$("button.fadeIn").click(() => {
  $("p.fadeIn").fadeIn('slow');
});

$("button.fadeOut").click(() => {
  $("p.fadeOut").fadeOut('slow');
});

$("button.before").click(() => {
  $("p.before").before("<strong>Hello</strong> ");
});

$("button.after").click(() => {
  $("p.after").after(" <strong>Goodbye</strong>");
});

$("button.html").click(() => {
  $("p.html").html("<strong>Hello</strong>");
});

$("button.attr").click(() => {
  $("input.attr").attr("type", "radio");
});

$("button.val").click(() => {
  $("input.val").val("Hello");
});

$("button.text").click(() => {
  $("p.text").text(" Hello");
});

