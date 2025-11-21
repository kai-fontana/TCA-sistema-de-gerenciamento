function scrollCarousel(direction) {
            const carousel = document.getElementById('classCarousel');
            if (!carousel) return;

            const scrollDistance = 300;

            if (direction === 'next') {

                carousel.scrollBy({
                    left: scrollDistance,
                    behavior: 'smooth'
                });
            } else if (direction === 'prev') {

                carousel.scrollBy({
                    left: -scrollDistance,
                    behavior: 'smooth'
                });
            }
        }